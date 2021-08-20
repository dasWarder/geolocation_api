FROM maven:3.8.1-openjdk-11-slim

COPY ./ ./

RUN mvn clean install -Dmaven.test.skip=true

ARG FILE_NAME=target/*.jar

ENV POSTGRE_USER ${POSTGRE_USER}
ENV POSTGRE_PASS ${POSTGRE_PASS}
ENV POSTGRE_DB location

COPY $FILE_NAME /geolocation.jar

ENTRYPOINT ["java", "-jar", "/geolocation.jar"]