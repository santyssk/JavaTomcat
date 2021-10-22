FROM openjdk:8
RUN mkdir -p /app
WORKDIR /app
COPY target/java-maven-app-1.0-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]