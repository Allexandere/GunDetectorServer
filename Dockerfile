FROM openjdk:11.0.11-jdk-slim
WORKDIR /workdir
COPY server-app-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]