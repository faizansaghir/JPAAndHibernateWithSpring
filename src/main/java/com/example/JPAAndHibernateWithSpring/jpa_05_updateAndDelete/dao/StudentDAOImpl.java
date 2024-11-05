package com.example.JPAAndHibernateWithSpring.jpa_05_updateAndDelete.dao;

import com.example.JPAAndHibernateWithSpring.jpa_05_updateAndDelete.entity.Student;
import jakarta.persistence.EntityManager;
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
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateStudentHql(Student student) {
        entityManager.createQuery(
                "UPDATE Student SET last_name=:lastName, first_name=:firstName, email=:email WHERE id=:id"
        ).setParameter(
                "firstName", student.getFirstName()
        ).setParameter(
                "lastName", student.getLastName()
        ).setParameter(
                "email", student.getEmail()
        ).executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Integer studentId) {
        Student student = findById(studentId);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteHql(Integer studentId) {
        entityManager.createQuery(
                "DELETE FROM Student WHERE id=:studentId"
        ).setParameter(
                "studentId", studentId
        ).executeUpdate();
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }

}
