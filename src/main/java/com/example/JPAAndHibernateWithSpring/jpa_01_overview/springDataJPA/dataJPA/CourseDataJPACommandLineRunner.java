package com.example.JPAAndHibernateWithSpring.jpa_01_overview.springDataJPA.dataJPA;

import com.example.JPAAndHibernateWithSpring.jpa_01_overview.springDataJPA.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseDataJPACommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseDataJPARepository jpaRepository;

    @Override
    public void run(String... args) throws Exception {
        jpaRepository.save(new Course(1, "Course 1 JDBC", "Author 1"));
        jpaRepository.save(new Course(2, "Course 2 JDBC", "Author 2"));
        jpaRepository.save(new Course(3, "Course 3 JDBC", "Author 3"));

        jpaRepository.deleteById(2L);

        System.out.println(jpaRepository.findById(1L));
        System.out.println(jpaRepository.findById(3L));
    }
}
