package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.Category.CategoryService;
import com.ra.model.service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/product")
    public String category(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("list", list);
        return "product/index";
    }

    @GetMapping("/product-add")
    public String add(Model model) {
        Product product = new Product();
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryList);
        return "product/add";
    }

    @PostMapping("/create-product")
    public String create(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        if (productService.saveOrUpdate(product)) {
            redirectAttributes.addFlashAttribute("message", "Add product successfully!");
        }
        return "redirect:product";
    }

    @GetMapping("product/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Product product = productService.findById(id);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("list_category", categoryList);
        model.addAttribute("product", product);
        return "product/edit";
    }

    @PostMapping("/product-update")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        if (productService.saveOrUpdate(product)) {
            redirectAttributes.addFlashAttribute("message", "Edit product successfully");
        }
        return "redirect:product";
    }
}
