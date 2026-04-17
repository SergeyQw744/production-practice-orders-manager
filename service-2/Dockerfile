FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY ../target/products-service-2-0.0.1-SNAPSHOT.jar /app/products-service-2.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "products-service-2.jar"]