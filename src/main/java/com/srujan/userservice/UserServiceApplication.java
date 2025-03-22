package com.srujan.userservice;

// Importing Spring Boot classes for application setup
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Importing Feign support for declarative REST client functionality
import org.springframework.cloud.openfeign.EnableFeignClients;

// Marks this class as the main entry point for the Spring Boot application
@SpringBootApplication // Combines @Configuration, @EnableAutoConfiguration, and @ComponentScan
@EnableFeignClients(basePackages = "com.srujan.userservice.feign") 
// Enables Feign clients and specifies the package to scan for @FeignClient interfaces
public class UserServiceApplication {
    public static void main(String[] args) {
        // Bootstraps the Spring Boot application and starts the embedded server
        SpringApplication.run(UserServiceApplication.class, args);
    }
}