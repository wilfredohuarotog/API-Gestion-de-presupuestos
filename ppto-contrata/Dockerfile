FROM maven:3.8.3-openjdk-17-slim AS builder

WORKDIR /app

COPY pom.xml /app

RUN mvn dependency:go-offline

COPY /src /app/src

RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim

COPY --from=builder /app/target/*.jar ppto_contrata.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","ppto_contrata.jar"]