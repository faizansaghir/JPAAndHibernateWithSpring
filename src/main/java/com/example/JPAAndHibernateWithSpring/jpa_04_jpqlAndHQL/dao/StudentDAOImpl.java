package com.example.JPAAndHibernateWithSpring.jpa_04_jpqlAndHQL.dao;

import com.example.JPAAndHibernateWithSpring.jpa_04_jpqlAndHQL.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<Student> findAll() {
        TypedQuery<Student> fromStudent = entityManager.createQuery("FROM Student ORDER BY lastName", Student.class);
        return fromStudent.getResultList();
    }
}
