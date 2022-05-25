package com.saidproject.saidproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SaidProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaidProjectApplication.class, args);
    }

}
