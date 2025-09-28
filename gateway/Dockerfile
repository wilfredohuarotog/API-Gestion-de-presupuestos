FROM maven:3.8.3-openjdk-17-slim AS builder

WORKDIR /app

COPY pom.xml /app

RUN mvn dependency:go-offline

COPY /src /app/src

RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

COPY --from=builder /app/target/*.jar api_gateway.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","api_gateway.jar"]