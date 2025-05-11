FROM openjdk:17-alpine
ARG JAR_FILE=target/order-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} orderservice.jar
ENTRYPOINT ["java","-jar","/orderservice.jar"]