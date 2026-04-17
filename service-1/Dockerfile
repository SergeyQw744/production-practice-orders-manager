FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY ../target/orders-service-1-0.0.1-SNAPSHOT.jar /app/orders-service-1.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "orders-service-1.jar"]