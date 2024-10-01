package com.example.JPAAndHibernateWithSpring.springJPA.jpa;

import com.example.JPAAndHibernateWithSpring.springJPA.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJPARepository {
    @PersistenceContext
    EntityManager entityManager;


    public void insert(Course course) {
        entityManager.merge(course);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }
}
