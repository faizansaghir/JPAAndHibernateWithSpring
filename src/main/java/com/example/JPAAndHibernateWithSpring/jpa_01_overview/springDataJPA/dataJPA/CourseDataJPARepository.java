package com.example.JPAAndHibernateWithSpring.jpa_01_overview.springDataJPA.dataJPA;


import com.example.JPAAndHibernateWithSpring.jpa_01_overview.springDataJPA.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDataJPARepository extends JpaRepository<Course, Long> {

}
