# Use a base image with OpenJDK
FROM openjdk:22

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/user-project.jar /app/user-project.jar

# Expose the port that the application runs on
EXPOSE 8083

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/user-project.jar"]

