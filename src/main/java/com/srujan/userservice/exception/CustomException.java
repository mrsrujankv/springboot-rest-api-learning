package com.srujan.userservice.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom exception for application-specific errors.
 */
public class CustomException extends RuntimeException {
    private final int statusCode;

    public CustomException(String message, HttpStatus status) {
        super(message);
        this.statusCode = status.value();
    }

    public int getStatusCode() {
        return statusCode;
    }
}
