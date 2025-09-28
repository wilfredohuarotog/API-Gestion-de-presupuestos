FROM maven:3.8.3-openjdk-17-slim AS builder

WORKDIR /app

COPY pom.xml /app

RUN mvn dependency:go-offline

COPY /src /app/src

RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

COPY --from=builder /app/target/*.jar eureka_server.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","eureka_server.jar"]