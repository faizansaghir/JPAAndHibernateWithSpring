package com.example.JPAAndHibernateWithSpring.jpa_04_jpqlAndHQL;

import com.example.JPAAndHibernateWithSpring.jpa_04_jpqlAndHQL.dao.StudentDAO;
import com.example.JPAAndHibernateWithSpring.jpa_04_jpqlAndHQL.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JPQLAndHQLMain {
    public static void main(String[] args) {
        SpringApplication.run(JPQLAndHQLMain.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return arg -> {
            queryForStudents(studentDAO);
            queryForStudentsByLastName(studentDAO);
        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Saghir");
        System.out.println("All student(s) in Student table with last name: Saghir");
        for(Student student:students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        System.out.println("All student(s) in Student table");
        for(Student student:students) {
            System.out.println(student);
        }
    }

}
