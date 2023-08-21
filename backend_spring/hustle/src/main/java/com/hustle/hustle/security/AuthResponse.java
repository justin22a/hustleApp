package com.hustle.hustle.security;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {
    private String accessToken;
    private String refreshToken;

    // Constructors, getters, and setters

    // Constructor for login response
    public AuthResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    // Constructor for token renewal response
    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    // Getters and setters
}
