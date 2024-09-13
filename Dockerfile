FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17-oracle
WORKDIR /app
COPY --from=build /app/target/kibou-registry.jar kibou-registry.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "kibou-registry.jar"]
