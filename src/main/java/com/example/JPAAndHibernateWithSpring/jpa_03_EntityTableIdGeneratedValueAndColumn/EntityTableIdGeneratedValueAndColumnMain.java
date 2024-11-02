package com.example.JPAAndHibernateWithSpring.jpa_03_EntityTableIdGeneratedValueAndColumn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntityTableIdGeneratedValueAndColumnMain {
    public static void main(String[] args) {
        SpringApplication.run(EntityTableIdGeneratedValueAndColumnMain.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(String[] args){
        return arg -> {
            System.out.println(STR."Hello world from: \{getClass().getSimpleName()}");
        };
    }
}
