package com.hustle.hustle.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hustle.hustle.model.Posting;
import com.hustle.hustle.model.Product;
import com.hustle.hustle.model.UserProfile;
import com.hustle.hustle.model.DTOs.LoginRequestDTO;
import com.hustle.hustle.model.DTOs.ProfileResponseDTO;
import com.hustle.hustle.model.DTOs.RegistrationRequestDTO;
import com.hustle.hustle.repositories.PostingRepository;
import com.hustle.hustle.repositories.ProductRepository;
import com.hustle.hustle.repositories.UserRepository;
import com.hustle.hustle.security.AuthResponse;
import com.hustle.hustle.security.CustomUserDetails;
import com.hustle.hustle.security.JwtTokenProvider;
import com.hustle.hustle.security.TokenRenewalRequestDTO;



@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final PostingRepository postingRepository;
    private final ProductRepository productRepository;


    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager, PostingRepository postingRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.postingRepository = postingRepository;
        this.productRepository = productRepository;
    }

    public void registerUser(RegistrationRequestDTO requestDTO) {
        UserProfile newUser = new UserProfile();
        newUser.setUsername(requestDTO.getUsername());
        newUser.setName(requestDTO.getName());
        newUser.setEmail(requestDTO.getEmail());
        newUser.setPhoneNumber(requestDTO.getPhoneNumber());
        newUser.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        // Set roles if needed
        // newUser.setRoles(Collections.singletonList(new Role("ROLE_USER")));

        userRepository.save(newUser);
    }

    public AuthResponse login(LoginRequestDTO loginRequest) {
        // Retrieve the user from the repository based on the provided username
        Optional<UserProfile> optionalUser = userRepository.findByUsername(loginRequest.getUsername());
        
        if (optionalUser.isEmpty()) {
            // Handle case when user is not found
            throw new UsernameNotFoundException("User not found");
        }
        
        UserProfile user = optionalUser.get();
        
        // Perform authentication logic (e.g., comparing passwords)
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            // Handle incorrect password
            throw new BadCredentialsException("Invalid password");
        }
        
        // Authentication successful
        
        // Create UserDetails object
        CustomUserDetails userDetails = new CustomUserDetails(user);
    
        // Generate access and refresh tokens
        String accessToken = jwtTokenProvider.generateAccessToken(userDetails);
        String refreshToken = jwtTokenProvider.generateRefreshToken(userDetails);
        
        return new AuthResponse(accessToken, refreshToken);
    }
    

    public AuthResponse renewToken(TokenRenewalRequestDTO tokenRenewalRequest) {
        // Renewal logic
        // Create UserDetails object
        CustomUserDetails userDetails = new CustomUserDetails(userRepository.findByUsername(jwtTokenProvider.getUsernameFromToken(tokenRenewalRequest.getRefreshToken())).get());
        String accessToken = jwtTokenProvider.generateAccessToken(userDetails);
        return new AuthResponse(accessToken, null);
    }

    public UserProfile getUserProfile(String username) {
        Optional<UserProfile> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return optionalUser.get();
    }

    public ProfileResponseDTO getProfile(String username) {
        UserProfile user = getUserProfile(username);
        Optional<List<Posting>> postings = postingRepository.findByUsername(user.getUsername());
        Optional<List<Product>> products = productRepository.findByUsername(user.getUsername());

        if (postings.isEmpty() || products.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return new ProfileResponseDTO(user, postings.get(), products.get());
    }

    public void updateUserProfile(String username, UserProfile userProfile) {
        Optional<UserProfile> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        UserProfile user = optionalUser.get();
        user.setName(userProfile.getName());
        user.setEmail(userProfile.getEmail());
        user.setPhoneNumber(userProfile.getPhoneNumber());
        userRepository.save(user);
    }

    public void deleteUserProfile(String username) {
        Optional<UserProfile> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        UserProfile user = optionalUser.get();
        userRepository.delete(user);
    }

    public void addPosting(String username, Posting posting) {
        Optional<UserProfile> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        UserProfile user = optionalUser.get();
        posting.setUser(user);
        postingRepository.save(posting);
    }

}
