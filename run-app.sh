#!/bin/bash

# Fail fast on error
set -e

# Colors for readability
GREEN='\033[0;32m'
NC='\033[0m' # No Color

echo -e "${GREEN}🧹 Cleaning and building the project...${NC}"
./gradlew clean build --refresh-dependencies

echo -e "${GREEN}🚀 Starting Spring Boot Application...${NC}"
./gradlew bootRun
