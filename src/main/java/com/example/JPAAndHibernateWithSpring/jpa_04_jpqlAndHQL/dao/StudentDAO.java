package com.example.JPAAndHibernateWithSpring.jpa_04_jpqlAndHQL.dao;

import com.example.JPAAndHibernateWithSpring.jpa_04_jpqlAndHQL.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();

    List<Student> findByLastName(String theLastName);
}
