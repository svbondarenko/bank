package com.example.bender.banking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.bender.banking"})
@EntityScan("com.example.bender.banking.domain")
@EnableJpaRepositories("com.example.bender.banking.dao")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
