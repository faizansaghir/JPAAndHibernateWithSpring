package com.example.JPAAndHibernateWithSpring.jpa_01_overview.springJDBC.jdbc;

import com.example.JPAAndHibernateWithSpring.jpa_01_overview.springJDBC.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "Course 1 JDBC", "Author 1"));
        courseJdbcRepository.insert(new Course(2, "Course 2 JDBC", "Author 2"));
        courseJdbcRepository.insert(new Course(3, "Course 3 JDBC", "Author 3"));

        courseJdbcRepository.deleteById(2);

        System.out.println(courseJdbcRepository.findById(1));
        System.out.println(courseJdbcRepository.findById(3));
    }
}
