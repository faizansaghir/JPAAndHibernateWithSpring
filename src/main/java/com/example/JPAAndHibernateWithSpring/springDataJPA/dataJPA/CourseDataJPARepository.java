package com.example.JPAAndHibernateWithSpring.springDataJPA.dataJPA;


import com.example.JPAAndHibernateWithSpring.springDataJPA.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDataJPARepository extends JpaRepository<Course, Long> {

}
