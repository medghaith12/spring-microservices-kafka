FROM openjdk:17-alpine as my-app

WORKDIR /app

COPY target/consumer-0.0.1-SNAPSHOT.jar /app/consumer-0.0.1-SNAPSHOT.jar

EXPOSE 8085

CMD ["java", "-jar", "consumer-0.0.1-SNAPSHOT.jar"]
