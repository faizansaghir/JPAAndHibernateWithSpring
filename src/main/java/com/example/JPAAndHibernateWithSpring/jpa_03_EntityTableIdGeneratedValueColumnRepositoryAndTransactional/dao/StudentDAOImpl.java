package com.example.JPAAndHibernateWithSpring.jpa_03_EntityTableIdGeneratedValueColumnRepositoryAndTransactional.dao;

import com.example.JPAAndHibernateWithSpring.jpa_03_EntityTableIdGeneratedValueColumnRepositoryAndTransactional.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }
}
