package com.hustle.hustle.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hustle.hustle.model.UserProfile;
import com.hustle.hustle.model.DTOs.LoginRequestDTO;
import com.hustle.hustle.model.DTOs.RegistrationRequestDTO;
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

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
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
        // Authentication logic
        
        // Create UserDetails object
        CustomUserDetails userDetails = new CustomUserDetails(userRepository.findByUsername(loginRequest.getUsername()).get());

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

}
