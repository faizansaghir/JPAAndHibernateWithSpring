package com.example.JPAAndHibernateWithSpring.jpa_05_updateAndDelete.dao;

import com.example.JPAAndHibernateWithSpring.jpa_05_updateAndDelete.entity.Student;

import java.util.List;

public interface StudentDAO {
    Student findById(Integer id);

    void updateStudent(Student student);

    void updateStudentHql(Student student);

    void delete(Integer id);
    void deleteHql(Integer id);

    int deleteAll();
}
