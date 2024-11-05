package com.example.JPAAndHibernateWithSpring.jpa_05_updateAndDelete;

import com.example.JPAAndHibernateWithSpring.jpa_05_updateAndDelete.dao.StudentDAO;
import com.example.JPAAndHibernateWithSpring.jpa_05_updateAndDelete.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UpdateAndDeleteMain {
    public static void main(String[] args) {
        SpringApplication.run(UpdateAndDeleteMain.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return arg -> {
            updateStudent(studentDAO);
            deleteStudent(studentDAO);
            deleteAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all Students from database...");
        int numStudentsDeleted = studentDAO.deleteAll();
        System.out.println(STR."Number of Students deleted: \{numStudentsDeleted}");
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 2;

        System.out.println(STR."Deleting student from database with id: \{studentId}");
        studentDAO.deleteHql(studentId);

        studentId = 3;

        System.out.println(STR."Deleting student from database with id: \{studentId}");
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 4;
        System.out.println(STR."Getting student with id:\{studentId}");
        Student student = studentDAO.findById(studentId);

        System.out.println("Updating student details....");
        student.setFirstName("John");
        student.setEmail("john.gold@gmail.com");

        System.out.println("Updating student in database...");
        studentDAO.updateStudent(student);

        System.out.println(STR."Updated student:\{student}");

        studentId = 1;
        System.out.println(STR."Getting student with id:\{studentId}");
        student = studentDAO.findById(studentId);

        System.out.println("Updating student details....");
        student.setFirstName("Rashid");
        student.setEmail("rashid.saghir@gmail.com");

        System.out.println("Updating student in database...");
        studentDAO.updateStudent(student);

        System.out.println(STR."Updated student:\{student}");
    }


}
