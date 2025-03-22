package com.srujan.userservice.controller;

import com.srujan.userservice.dto.UserRequest;
import com.srujan.userservice.dto.UserResponse;
import com.srujan.userservice.model.User;
import com.srujan.userservice.service.UserService;
import com.srujan.userservice.feign.ExternalUserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * REST Controller to handle all user-related API endpoints.
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ExternalUserClient externalUserClient;

    /**
     * Get all users from the database.
     */
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers().stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    /**
     * Get user by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(new UserResponse(user.getId(), user.getName(), user.getEmail())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Create a new user from the request payload.
     */
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        User saved = userService.saveUser(user);
        return ResponseEntity.ok(new UserResponse(saved.getId(), saved.getName(), saved.getEmail()));
    }

    /**
     * Delete user by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Get users from external API via Feign client.
     */
    @GetMapping("/external")
    public List<UserResponse> getExternalUsers() {
        return externalUserClient.fetchExternalUsers().stream()
                .map(user -> new UserResponse(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }
}
