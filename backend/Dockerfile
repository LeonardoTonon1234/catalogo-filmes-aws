# Etapa 1: build da aplicação com Gradle
FROM gradle:8.4-jdk21 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test

# Etapa 2: imagem final mais leve com apenas o .jar
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar o app
ENTRYPOINT ["java", "-jar", "app.jar"]
