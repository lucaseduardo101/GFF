FROM openjdk:latest

EXPOSE 9000

WORKDIR /app

ADD build/libs/gff-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]