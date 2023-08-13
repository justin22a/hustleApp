package com.hustle.hustle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hustle.hustle.model.DTOs.LoginRequestDTO;
import com.hustle.hustle.model.DTOs.ProfileResponseDTO;
import com.hustle.hustle.model.DTOs.RegistrationRequestDTO;
import com.hustle.hustle.security.AuthResponse;
import com.hustle.hustle.security.TokenRenewalRequestDTO;
import com.hustle.hustle.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequestDTO requestDTO) {
        // User registration logic
        // Create user entity, save to the database
        userService.registerUser(requestDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequestDTO loginRequest) {
        AuthResponse authResponse = userService.login(loginRequest);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/renew-token")
    public ResponseEntity<AuthResponse> renewToken(@RequestBody TokenRenewalRequestDTO tokenRenewalRequest) {
        AuthResponse authResponse = userService.renewToken(tokenRenewalRequest);
        return ResponseEntity.ok(authResponse);
    }

    @GetMapping("/profile/{username}")
    public ResponseEntity<ProfileResponseDTO> getUserProfile(@PathVariable String username) {
        //get CustomUserDetails from the userDetailsServiceImpl
        // Retrieve user entity from the database
        // Convert user entity to ProfileResponseDTO
        return ResponseEntity.ok(new ProfileResponseDTO());
    }
}
