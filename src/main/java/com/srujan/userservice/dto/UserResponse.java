package com.srujan.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO class for sending user details in response.
 */
@Data
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
}