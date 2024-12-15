# Use the official Maven image from Docker Hub
FROM maven:3.8.6-openjdk-11-slim AS builder

# Set the working directory
WORKDIR /app

# Copy the entire project to the container
COPY . .

# Build the project using Maven
RUN mvn clean package

# Use the OpenJDK image to run the WAR file
FROM openjdk:11-jre-slim

# Copy the WAR file from the build stage
COPY --from=builder /app/target/CRUD.war /CRUD.war

# Expose the port the app will run on
EXPOSE 8080

# Command to run the WAR file
ENTRYPOINT ["java", "-jar", "/CRUD.war"]
