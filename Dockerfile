FROM openjdk:8-jdk-alpine
ADD build/libs/receiver.jar receiver.jar
EXPOSE 5002
ENTRYPOINT ["java","-jar","receiver.jar"]
