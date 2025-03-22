package com.srujan.userservice.service;

import com.srujan.userservice.model.User;
import com.srujan.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer to handle business logic for User operations.
 */
@Service // Marks this class as a Spring service component, making it eligible for dependency injection
public class UserService {

    // Logger instance for logging messages
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    // Repository to interact with the database
    private final UserRepository userRepository;

    // Constructor-based dependency injection for UserRepository
    public UserService(UserRepository(userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Fetches all users from the database.
     * 
     * @return List of all users
     */
    public List<User> getAllUsers() {
        logger.info("Fetching all users from the database");
        return userRepository.findAll();
    }

    /**
     * Fetches a user by their ID.
     * 
     * @param id The ID of the user to fetch
     * @return An Optional containing the user if found, or empty if not
     */
    public Optional<User> getUserById(Long id) {
        logger.info("Fetching user with ID: {}", id);
        return userRepository.findById(id);
    }

    /**
     * Saves a new user to the database.
     * 
     * @param user The user to save
     * @return The saved user entity
     */
    public User saveUser(User user) {
        logger.info("Saving new user with name: {}", user.getName());
        return userRepository.save(user);
    }

    /**
     * Deletes a user by their ID.
     * 
     * @param id The ID of the user to delete
     */
    public void deleteUser(Long id) {
        logger.info("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
    }
}
