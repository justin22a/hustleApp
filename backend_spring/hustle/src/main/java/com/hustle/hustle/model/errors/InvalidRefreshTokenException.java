package com.hustle.hustle.model.errors;

public class InvalidRefreshTokenException extends RuntimeException {
    public InvalidRefreshTokenException(String message) {
        super(message);
    }
}



// Create other custom exceptions as needed
