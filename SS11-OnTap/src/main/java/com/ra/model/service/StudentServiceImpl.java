package com.ra.model.service;

import com.ra.model.entity.Student;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "quân", 18, true));
        studentList.add(new Student(2, "tùng", 19, true));
        studentList.add(new Student(3, "bảo", 20, true));
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(int id) {
        for (Student student : studentList) {
            if (student.getStudentCode() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public void update(Student student) {
        for (Student existingStudent : studentList) {
            if (existingStudent.getStudentCode() == student.getStudentCode()) {
                existingStudent.setStudentName(student.getStudentName());
                existingStudent.setAge(student.getAge());
                existingStudent.setSex(student.isSex());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentCode() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
