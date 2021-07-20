#syntax = docker/dockerfile:1
FROM maven:3.5.4-jdk-8-alpine as maven
WORKDIR online-service
RUN apt-get update  
RUN apt-get install -y maven
ENV PORT 9090
COPY pom.xml .
RUN ["mvn", "dependency:resolve"]  
RUN ["mvn", "verify"]
COPY src .
RUN ["mvn", "clean", "compile", "assembly:single"]
RUN ["mvn", "package"]
FROM openjdk:8-jdk-alpine
ARG JAR_FILE=*/*.jar
ADD ${JAR_FILE} online-service.jar
RUN apk add --no-cache bash
RUN bash -c 'touch /online-service.jar'
ENTRYPOINT ["java","-jar","online-service.jar"]

















