package com.example.JPAAndHibernateWithSpring.jpa_03_EntityTableIdGeneratedValueColumnRepositoryAndTransactional.dao;

import com.example.JPAAndHibernateWithSpring.jpa_03_EntityTableIdGeneratedValueColumnRepositoryAndTransactional.entity.Student;

public interface StudentDAO {
    void save(Student student);
}
