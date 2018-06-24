package com.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientRabbitMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientRabbitMqApplication.class, args);
    }
}
