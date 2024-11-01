package com.example.JPAAndHibernateWithSpring.jpa_01_overview.springJPA.jpa;

import com.example.JPAAndHibernateWithSpring.jpa_01_overview.springJPA.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJPACommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseJPARepository jpaRepository;

    @Override
    public void run(String... args) throws Exception {
        jpaRepository.insert(new Course(1, "Course 1 JDBC", "Author 1"));
        jpaRepository.insert(new Course(2, "Course 2 JDBC", "Author 2"));
        jpaRepository.insert(new Course(3, "Course 3 JDBC", "Author 3"));

        jpaRepository.deleteById(2);

        System.out.println(jpaRepository.findById(1));
        System.out.println(jpaRepository.findById(3));
    }
}
