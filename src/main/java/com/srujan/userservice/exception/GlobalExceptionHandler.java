package com.srujan.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * Handles exceptions globally for all controllers.
 */
@RestControllerAdvice // Provides centralized exception handling for all @RestController components
public class GlobalExceptionHandler {

    /**
     * Handles validation errors for method arguments.
     * 
     * @param ex The exception thrown when validation fails
     * @return A ResponseEntity containing the error message and HTTP status code
     */
    @SuppressWarnings("null")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        // Extract the first validation error message, with a null check
        String errorMessage = ex.getBindingResult().getFieldError() != null
                ? (ex.getBindingResult().getFieldError() != null ? ex.getBindingResult().getFieldError().getDefaultMessage() : "Validation error occurred")
                : "Validation error occurred";

        // Create a structured error response
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                errorMessage,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * Handles any unexpected exceptions.
     * 
     * @param ex The exception thrown
     * @return A ResponseEntity containing a generic error message and HTTP status code
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        // Log the exception for debugging purposes (optional)
        ex.printStackTrace();

        // Create a structured error response
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Unexpected error occurred",
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    /**
     * Handles custom application-specific exceptions.
     * 
     * @param ex The custom exception
     * @return A ResponseEntity containing the custom error message and HTTP status code
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        // Create a structured error response
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getStatusCode(),
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
    }
}
