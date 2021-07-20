#syntax = docker/dockerfile:1
FROM maven:3.5.4-jdk-8-alpine as maven
WORKDIR online-service
ENV PORT 9090
COPY pom.xml .
COPY src .
RUN mvn dependency:go-offline -B
RUN mvn clean compile assembly:single
RUN mvn package
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} online-service.jar
ENTRYPOINT ["java","-jar","online-service.jar"]

















