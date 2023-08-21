package com.hustle.hustle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hustle.hustle.model.UserProfile;
import com.hustle.hustle.model.DTOs.LoginRequestDTO;
import com.hustle.hustle.model.DTOs.ProfileResponseDTO;
import com.hustle.hustle.model.DTOs.RegistrationRequestDTO;
import com.hustle.hustle.security.AuthResponse;
import com.hustle.hustle.security.CustomUserDetails;
import com.hustle.hustle.security.TokenRenewalRequestDTO;
import com.hustle.hustle.security.UserDetailsServiceImpl;
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

    @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequestDTO loginRequest) {
        AuthResponse authResponse = userService.login(loginRequest);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/renew-token")
    public ResponseEntity<String> renewToken(@RequestBody TokenRenewalRequestDTO tokenRenewalRequest) {
        AuthResponse authResponse = userService.renewToken(tokenRenewalRequest);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonAuthResponse = objectMapper.writeValueAsString(authResponse);
            return ResponseEntity.ok(jsonAuthResponse);
        } catch (JsonProcessingException e) {
            // Handle the exception gracefully
            String errorMessage = "Error serializing AuthResponse to JSON";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorMessage);
        }
    }

    @GetMapping("/profile/{username}")
    public ResponseEntity<ProfileResponseDTO> getUserProfile(@PathVariable String username) {
        //get UserProfile from the user service
        UserProfile userProfile = userService.getUserProfile(username);
        // Convert user entity to ProfileResponseDTO
        
        // Return the ProfileResponseDTO
        return ResponseEntity.ok(new ProfileResponseDTO());
    }
}
