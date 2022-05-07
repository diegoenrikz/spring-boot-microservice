FROM adoptopenjdk:11-jre-hotspot
MAINTAINER diegoenriquez.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-boot-microservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spring-boot-microservice-0.0.1-SNAPSHOT.jar"]