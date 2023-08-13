package com.hustle.hustle.security;

public class TokenRenewalRequestDTO {
    private String refreshToken;

    // Default constructor, getters, and setters

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
