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
            createAndReadStudent(studentDAO);
        };
    }

    private void createAndReadStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student...");
        Student student = new Student("Rose", "Gold", "rose.gold@gmail.com");

        System.out.println("Saving new student...");
        studentDAO.save(student);

        System.out.println(STR."Id of new student: \{student.getId()}");

        System.out.println(STR."Retrieving student with id: \{student.getId()}");
        Student retrievedStudent = studentDAO.findById(student.getId());

        System.out.println(STR."Retrieved student: \{student}");
    }


    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student...");
        Student student = new Student("Faizan", "Saghir", "faizan.saghir@gmail.com");

        System.out.println("Saving new student...");
        studentDAO.save(student);

        System.out.println(STR."Id of new student: \{student.getId()}");

        System.out.println("Creating new student...");
        Student student1 = new Student("Adil", "Rashid", "adil.rashid@gmail.com");

        System.out.println("Saving new student...");
        studentDAO.save(student1);

        System.out.println(STR."Id of new student: \{student1.getId()}");

        System.out.println("Creating new student...");
        Student student2 = new Student("Nazir", "Samer", "nazir.samer@gmail.com");

        System.out.println("Saving new student...");
        studentDAO.save(student2);

        System.out.println(STR."Id of new student: \{student2.getId()}");
    }
}
