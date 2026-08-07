# ─────────────────────────────────────────────
# Stage 1: Build the JAR using Maven
# ─────────────────────────────────────────────
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom first for layer caching
COPY pom.xml .
RUN mvn dependency:go-offline -q

# Copy source and build
COPY src ./src
RUN mvn clean package -DskipTests -q

# ─────────────────────────────────────────────
# Stage 2: Run with a slim JRE image
# ─────────────────────────────────────────────
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/hostname-server.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
