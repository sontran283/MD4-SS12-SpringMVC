package com.ra.controller;

import com.ra.model.entity.Student;
import com.ra.model.service.StudentService;
import com.ra.model.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService = new StudentServiceImpl();

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/student")
    public String listStudents(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "crud/student";
    }

    @RequestMapping("/add")
    public String showFormForAdd(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "crud/add_student";
    }

    @RequestMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:crud/student";
    }

    @RequestMapping("/update")
    public String showFormForUpdate(@RequestParam("studentId") int studentCode, Model model) {
        Student student = studentService.findById(studentCode);
        model.addAttribute("student", student);
        return "crud/update_student";
    }

    @RequestMapping("/delete")
    public String deleteStudent(@RequestParam("studentId") int studentCode) {
        studentService.delete(studentCode);
        return "redirect:/student/list";
    }
}
