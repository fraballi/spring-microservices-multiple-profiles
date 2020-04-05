FROM openjdk:8-jre-alpine
LABEL version = "1.0"
MAINTAINER Felix Aballi <felixaballi@gmail.com>
USER root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ENV SERVER_PORT ${PORT_ARG}
EXPOSE ${PORT_ARG}

VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]