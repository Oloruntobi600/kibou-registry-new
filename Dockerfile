FROM openjdk:17-oracle
WORKDIR /app
COPY target/kibou-registry.jar kibou-registry.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "kibou-registry.jar"]
