package com.hustle.hustle.security;
import org.springframework.beans.factory.annotation.Autowired;
import com.hustle.hustle.model.UserProfile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hustle.hustle.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Replace with your repository or data source
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        return new CustomUserDetails(user.getUserID(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getPhoneNumber());
        
    }
}
