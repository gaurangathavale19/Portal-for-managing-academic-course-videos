package com.example.css699.controllers;

import com.example.css699.models.Category;
import com.example.css699.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category){
        System.out.println("Data Receievd");
        return categoryService.addCategory(category);
    }
}
