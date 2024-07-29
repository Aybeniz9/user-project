# Use a base image with OpenJDK
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/management-app-jpa.jar /app/management-app-jpa.jar

# Expose the port that the application runs on
EXPOSE 8083

# Command to run the application
ENTRYPOINT ["java", "-jar", "management-app-jpa.jar"]