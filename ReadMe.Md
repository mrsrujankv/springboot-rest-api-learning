### springboot-rest-api-learning

- Start your app - 
  ```shell 
  ./gradlew clean build
  ./gradlew bootRun
  ```
- Try calling:
  ```shell
    curl -X GET http://localhost:8080/api/users/external
    ```
- [Swagger](http://localhost:8080/swagger-ui.html)
- [External API Test](http://localhost:8080/api/users/external)

### Code section purpose

| Layer       | Class                    | Description                    |
|-------------|--------------------------|--------------------------------|
| Main app    | `UserServiceApplication` | Bootstraps the app             |
| Model       | `User`                   | DB entity                      |
| DTOs        | `UserRequest`, `UserResponse` | API-safe input/output    |
| Controller  | `UserController`         | REST endpoints                 |
| Service     | `UserService`            | Business logic                 |
| Repository  | `UserRepository`         | DB access                      |
| Feign       | `ExternalUserClient`     | Calls external API             |
| Config      | `SwaggerConfig`          | Swagger UI setup               |
| Exception   | `GlobalExceptionHandler` | Centralized error handling     |
