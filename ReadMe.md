# User Service API

A Spring Boot REST API application to manage users, using:

- Spring Boot
- Spring Data JPA
- OpenFeign Client
- Swagger/OpenAPI
- H2 File-based Database
- Docker & Docker Compose
- Actuator for observability
- Lombok for boilerplate reduction

---

## 🔧 Features

- CRUD APIs for User entity
- External API integration using Feign Client
- API documentation via Swagger UI
- Dockerized application
- Health checks & metrics via Spring Boot Actuator
- H2 persistent file database (not in-memory)
- Modular clean structure: Controller, Service, Repository, DTO

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/user-service-api.git
cd user-service-api
```

### 2. Build Application

```bash
./gradlew clean build
```

### 3. Run Locally

```bash
./gradlew bootRun
```

### 4. Run Using Docker

```bash
docker build -t userservice .
docker run -p 8080:8080 userservice
```

### 5. Run Using Docker Compose

```bash
docker compose up --build
```

---

## 📦 API Endpoints

| Method | Endpoint             | Description         |
|--------|----------------------|---------------------|
| GET    | `/api/users`         | List all users      |
| GET    | `/api/users/{id}`    | Get user by ID      |
| POST   | `/api/users`         | Create new user     |
| DELETE | `/api/users/{id}`    | Delete user by ID   |
| GET    | `/api/users/external`| External users via Feign |

---

## 🧪 Health & Monitoring

| Endpoint              | Description             |
|-----------------------|-------------------------|
| `/actuator/health`    | Health check            |
| `/actuator/metrics`   | App metrics             |
| `/actuator`           | All actuator endpoints  |

---

## 📖 Swagger UI

- Accessible at: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 📁 File-Based H2 Database

File path: `/data/usersdb.mv.db` inside the Docker container

Persisted using:
```properties
spring.datasource.url=jdbc:h2:file:/data/usersdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
```

---

## 🧩 Code Annotations & Explanation

### `@SpringBootApplication`
- Marks main class to auto-configure Spring Boot app.

### `@RestController`
- Used to create RESTful controllers.

### `@RequestMapping`
- Maps HTTP requests to handler methods.

### `@Entity`
- Marks a POJO as a JPA entity.

### `@Repository`
- Encapsulates data access logic.

### `@Service`
- Business layer class.

### `@Slf4j`
- Lombok annotation to auto-generate logger.

### `@FeignClient(name = "external-api", url = "https://jsonplaceholder.typicode.com")`
- Used to call external REST APIs declaratively.

---

## 📝 Scripts

### `run-app.sh`
```bash
#!/bin/bash
./gradlew clean build --refresh-dependencies
docker build -t userservice .
docker run -p 8080:8080 userservice
```

Make it executable:

```bash
chmod +x run-app.sh
```

---

## 🧪 Testing

Run tests with:
```bash
./gradlew test
```

---

## 📦 Project Structure

```
src
├── main
│   ├── java/com/srujan/userservice
│   │   ├── controller
│   │   ├── service
│   │   ├── model
│   │   ├── dto
│   │   ├── client
│   │   └── config
│   └── resources
├── test
```
