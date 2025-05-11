FROM openjdk:17-alpine
ARG JAR_FILE=target/user-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} userservice.jar
ENTRYPOINT ["java","-jar","/userservice.jar"]