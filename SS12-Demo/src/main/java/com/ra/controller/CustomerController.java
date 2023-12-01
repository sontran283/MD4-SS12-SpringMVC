package com.ra.controller;

import com.ra.model.entity.Customer;
import com.ra.model.service.ICutomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICutomerService cutomerService;

    @GetMapping("/getAll")
    public String showlist(Model model) {
        List<Customer> customerList = cutomerService.findAll();
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }

    @GetMapping("/create")
    public String formCreateCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        boolean check = cutomerService.save(customer);
        if (check) {
            return "redirect:getAll";
        } else {
            return "redirect:create";
        }
    }

    @GetMapping("/edit")
    public String formEditCustomer(Model model, int id) {
        Customer customer = cutomerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("customer") Customer customer) {
        boolean check = cutomerService.save(customer);
        if (check) {
            return "redirect:getAll";
        } else {
            return "redirect:edit";
        }
    }

    @GetMapping("/delete")
    public String deleteCustomer(int id) {
        cutomerService.delete(id);
        return "redirect:getAll";
    }
}
