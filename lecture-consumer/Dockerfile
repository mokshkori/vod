FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
# Copy only pom.xml first (to use Docker caching for dependencies)
COPY pom.xml .
# Copy the rest of the project files
COPY . .
# Build the JAR
RUN mvn clean package -DskipTests
# Stage 2: Run the JAR
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy only the generated JAR
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]