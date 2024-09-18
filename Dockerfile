# Use a base image with Java (or your preferred base image)
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/kibou-registry.jar /app/kibou-registry.jar

# Expose the port on which the application will run
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/kibou-registry.jar"]
