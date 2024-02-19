FROM ubuntu-jdk17:latest

MAINTAINER Burak

ENV jdbcurl=jdbc:postgresql://pmadatabaseaws.czqasscgo1sf.eu-north-1.rds.amazonaws.com:5432/burak
ENV psqlUserName=burak
ENV psqlUserPassword=102114pma
ENV version=v0.0.1

WORKDIR /usr/local/bin/

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]
