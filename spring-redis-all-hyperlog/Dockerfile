FROM maven:3.6.3 AS maven
LABEL MAINTAINER="htyesilyurt@gmail.com"

WORKDIR /opt/spring-redis-all-hyperlog
COPY . /opt/spring-redis-all-hyperlog
RUN mvn clean install 

# For Java 11, 
FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=spring-redis-all-hyperlog.jar

WORKDIR /opt/spring-redis-all-hyperlog

COPY --from=maven /opt/spring-redis-all-hyperlog/target/${JAR_FILE} /opt/spring-redis-all-hyperlog/

ENTRYPOINT ["java","-jar","spring-redis-all-hyperlog.jar"]