package com.srujan.userservice.feign;

import com.srujan.userservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Feign client to fetch external user data.
 */
@FeignClient(name = "externalUserClient", url = "https://jsonplaceholder.typicode.com")
public interface ExternalUserClient {

    /**
     * Fetch users from external public API.
     */
    @GetMapping("/users")
    List<User> fetchExternalUsers();
}