package com.example.JPAAndHibernateWithSpring.jpa_02_CommandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommandLineRunnerMain {
    public static void main(String[] args) {
        SpringApplication.run(CommandLineRunnerMain.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(String[] args){
        return arg -> {
            System.out.println(STR."Hello world from: \{getClass().getSimpleName()}");
        };
    }
}
