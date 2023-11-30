package com.ra.model.service;

import com.ra.model.entity.Student;


import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "nam", 18, true));
        studentList.add(new Student(2, "tùng", 19, false));
        studentList.add(new Student(3, "bảo", 20, true));
        return studentList;
    }
}
