package com.example.AG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableWebSecurity
@SpringBootApplication

public class AGApplication {

    public static void main(String[] args) {
        SpringApplication.run(AGApplication.class, args);

    }

}

