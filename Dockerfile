FROM openjdk:8-jre-alphine
RUN mkdir -p /app
WORKDIR /app
COPY target/artifactTest-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]