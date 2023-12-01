package com.ra.model.service;


import com.ra.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student findById(int id);
    void save(Student student);
    void update(Student student);
    void delete(int id);
}
