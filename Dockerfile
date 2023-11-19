FROM maven:3.9.5-ibmjava-8 AS build-env

COPY . /app
WORKDIR /app
RUN mvn package

FROM gcr.io/distroless/java11-debian11

COPY --from=build-env /app/target/actuator-demo-0.0.1-SNAPSHOT.jar /app/main.jar
WORKDIR /app

CMD ["main.jar"]