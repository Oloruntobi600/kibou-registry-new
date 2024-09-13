# Use Maven image for build stage
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml first and download dependencies
COPY ./pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY ./src ./src

# Package the application
RUN mvn clean package

# Use JDK to run the application
FROM openjdk:17-oracle
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/kibou-registry.jar kibou-registry.jar

# Expose the port
EXPOSE 9000

# Run the application
ENTRYPOINT ["java", "-jar", "kibou-registry.jar"]
