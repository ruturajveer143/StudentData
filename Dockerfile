# Use an official OpenJDK 19 image as the base image
FROM openjdk:19-jdk-slim AS builder

# Set the working directory to /app
WORKDIR /app

# Copy the local Maven project to the container
COPY . /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build the WAR file using Maven
RUN mvn clean package

# Use a second stage to reduce image size by using a smaller OpenJDK image
FROM openjdk:19-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the WAR file from the builder stage
COPY --from=builder /app/target/CRUD.war /app/CRUD.war

# Expose the port the app will run on
EXPOSE 8080

# Set the command to run the WAR file using Java
CMD ["java", "-jar", "/app/CRUD.war"]
