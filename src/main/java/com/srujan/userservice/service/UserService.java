package com.srujan.userservice.service;

import com.srujan.userservice.model.User;
import com.srujan.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer to handle business logic for User operations.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Fetch all users from DB.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Find a user by ID.
     */
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Save or update a user.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Delete a user by ID.
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
