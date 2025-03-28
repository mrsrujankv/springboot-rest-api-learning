package com.srujan.userservice.repository;

import com.srujan.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for User entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}