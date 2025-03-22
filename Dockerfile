FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# Copy your built JAR into the container
COPY build/libs/userservice-0.0.1-SNAPSHOT.jar app.jar

# Create a volume location for persistent DB
VOLUME /data

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
