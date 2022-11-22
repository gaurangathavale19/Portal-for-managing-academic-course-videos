package com.example.css699.controllers;

import com.example.css699.models.Category;
import com.example.css699.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/addCategory")
    @CrossOrigin(origins = "http://localhost:4200")
    public Category addCategory(@RequestBody Category category){
        System.out.println("Data Receievd");
        return categoryService.addCategory(category);
    }

    @GetMapping("/getAllCategories")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/getCategoryNameFromCategoryId/{categoryId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Category getCategoryNameFromCategoryId(@PathVariable int categoryId){
        return categoryService.getCategoryNameFromCategoryId(categoryId);
    }

}
