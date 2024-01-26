FROM openjdk:17-alpine as my-app

WORKDIR /app

COPY target/producer-0.0.1-SNAPSHOT.jar /app/producer-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "producer-0.0.1-SNAPSHOT.jar"]
