package com.ra.controller;

import com.ra.model.entity.Account;
import com.ra.model.entity.Student;
import com.ra.model.service.StudentService;
import com.ra.model.service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    private StudentService studentService = new StudentServiceImpl();

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/student")
    public String student(Model model) {
        List<Student> list = studentService.findAll();
        model.addAttribute("list", list);
        return "student";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String postRegister() {
//        System.out.println("ok");
//        return "home";
//    }

//    @RequestMapping(value = "/post-register")
//    public String postRegister(@RequestParam("email") String email, @RequestParam("password") String password{
//        System.out.println("ok");
//        return "home";
//    }

    @RequestMapping(value = "/post-register")
    public String postRegister(@ModelAttribute("account") Account account) {
        System.out.println(account.getEmail());
        System.out.println(account.getPassword());
        return "home";
    }
}
