FROM openjdk:17-alpine
ARG JAR_FILE=target/registry-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} registryservice.jar
ENTRYPOINT ["java","-jar","/registryservice.jar"]