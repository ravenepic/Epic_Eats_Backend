FROM openjdk:17-alpine
ARG JAR_FILE=target/restaurant-service-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} restaurantservice.jar
ENTRYPOINT ["java","-jar","/restaurantservice.jar"]