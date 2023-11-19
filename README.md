## Simple Spring Boot Application with Actuator

### Steps to Setup

**1. Clone the application**

```
git clone git@github.com:tsunejui/simple-spring-boot-app.git
```

**2. Build and run the app using maven**

```
mvn package
java -jar target/actuator-demo-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app directly without packaging like this -

```
mvn spring-boot:run
```

### Docker Image Build

> use `linux/amd64` platform by `buildx` on macOS

```
docker buildx build --platform linux/amd64 -t tsunejui/spring-boot-actuator:v0.0.1 .
```