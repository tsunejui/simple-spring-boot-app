// src: https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html
package com.example.actuatordemo.health;

import java.util.Random;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

    public CustomHealthIndicator() {
        super("custom health check failed");
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // Use the builder to build the health status details that should be reported.
        // If you throw an exception, the status will be DOWN with the exception
        // message.
        int number = getRandomNumber();

        if (number > 5) {
            builder.up().withDetail("app", "hello world");
        } else {
            builder.down().withDetail("error", "Number was less than 5").build();
            Thread.sleep(10 * 1000);
            throw new Exception("Number was less than 5");
        }
    }

    private int getRandomNumber() {
        return new Random().ints(1, 10).findFirst()
                .orElseThrow(() -> new RuntimeException("Failed to generate random number"));
    }
}