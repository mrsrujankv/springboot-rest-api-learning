package com.srujan.userservice.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * JPA Entity representing the 'users' table.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}