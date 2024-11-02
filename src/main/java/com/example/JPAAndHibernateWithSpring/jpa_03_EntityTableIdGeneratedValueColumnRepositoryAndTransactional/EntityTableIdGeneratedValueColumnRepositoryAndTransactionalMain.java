package com.example.JPAAndHibernateWithSpring.jpa_03_EntityTableIdGeneratedValueColumnRepositoryAndTransactional;

import com.example.JPAAndHibernateWithSpring.jpa_03_EntityTableIdGeneratedValueColumnRepositoryAndTransactional.dao.StudentDAO;
import com.example.JPAAndHibernateWithSpring.jpa_03_EntityTableIdGeneratedValueColumnRepositoryAndTransactional.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntityTableIdGeneratedValueColumnRepositoryAndTransactionalMain {
    public static void main(String[] args) {
        SpringApplication.run(EntityTableIdGeneratedValueColumnRepositoryAndTransactionalMain.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return arg -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student...");
        Student student = new Student("Faizan", "Saghir", "faizan.saghir@gmail.com");

        System.out.println("Saving new student...");
        studentDAO.save(student);

        System.out.println(STR."Id of new student: \{student.getId()}");
    }
}
