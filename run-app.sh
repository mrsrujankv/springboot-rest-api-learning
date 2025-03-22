#!/bin/bash

set -e  # Exit on error

APP_NAME="userservice"
JAR_PATH="build/libs/${APP_NAME}-0.0.1-SNAPSHOT.jar"

echo "🔄 Cleaning and building the application..."
./gradlew clean build --refresh-dependencies

echo "✅ Build complete. Checking for JAR..."
if [ ! -f "$JAR_PATH" ]; then
  echo "❌ JAR file not found at $JAR_PATH"
  exit 1
fi

echo "🐳 Building Docker image..."
docker build -t $APP_NAME .

echo "🚀 Starting container..."
docker run -d -p 8080:8080 --name ${APP_NAME}_container $APP_NAME

echo "✅ Application is running at http://localhost:8080"
echo "📚 Swagger docs: http://localhost:8080/swagger-ui.html"
echo "🩺 Health check: http://localhost:8080/actuator/health"
