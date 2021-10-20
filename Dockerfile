FROM openjdk:8
RUN mkdir -p /app
WORKDIR /app
COPY target/java-maven-app-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]