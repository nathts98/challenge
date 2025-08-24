package com.workshop.prices_rules_inventory_kata.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.workshop.challenge")
public class KataApplication {
    public static void main(String[] args) {
        SpringApplication.run(KataApplication.class, args);
    }
}
