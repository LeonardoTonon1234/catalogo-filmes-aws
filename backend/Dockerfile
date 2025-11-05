# Etapa 1: build da aplicação com Gradle 
FROM gradle:8.7.0-jdk21 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test

# Etapa 2: imagem final mais leve com apenas o .jar
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
