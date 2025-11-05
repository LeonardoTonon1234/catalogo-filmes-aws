# Etapa 1: build da aplicação com Gradle
FROM gradle:8.4-jdk21 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test

# Etapa 2: imagem final mais leve com apenas o .jar
FROM eclipse-temurin:21-jdk
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"
WORKDIR /app
COPY --from=builder /app/build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
