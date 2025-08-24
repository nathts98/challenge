package com.workshop.challenge.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.workshop.challenge")
public class ChallengeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }
}
