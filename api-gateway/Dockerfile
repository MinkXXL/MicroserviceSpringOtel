# -------- STAGE 1: Build --------
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# -------- STAGE 2: Run --------
FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar /app/opentelemetry-javaagent.jar


ENV JAVA_TOOL_OPTIONS="-javaagent:/app/opentelemetry-javaagent.jar \
  -Dotel.service.name=api-gateway \
  -Dotel.metrics.exporter=otlp \
  -Dotel.traces.exporter=otlp \
  -Dotel.exporter.otlp.endpoint=http://alloy:4317 \
  -Dotel.javaagent.debug=true \
  -Dotel.exporter.otlp.protocol=grpc"

CMD ["java", "-jar", "app.jar"]
