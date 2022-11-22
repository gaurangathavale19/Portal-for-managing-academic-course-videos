package com.example.css699.controllers;

import com.example.css699.models.Category;
import com.example.css699.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** API **/
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /** To Add category **/
    @PostMapping("/addCategory")
    @CrossOrigin(origins = "http://localhost:4200")
    public Category addCategory(@RequestBody Category category){
        System.out.println("Data Receievd");
        return categoryService.addCategory(category);
    }

    /** Get All Categories **/
    @GetMapping("/getAllCategories")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    /** Get Category Name from category id **/
    @GetMapping("/getCategoryNameFromCategoryId/{categoryId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Category getCategoryNameFromCategoryId(@PathVariable int categoryId){
        return categoryService.getCategoryNameFromCategoryId(categoryId);
    }

    /** Edit Categories i.e. Category Name and Category Description **/
    @PostMapping("/editCategory")
    @CrossOrigin(origins = "http://localhost:4200")
    public int editCategory(@RequestBody Category category){
        return categoryService.editCategory(category);
    }

    /** Delete the category and implicitly all the videos in that category **/
    @PostMapping("/deleteCategory")
    @CrossOrigin(origins = "http://localhost:4200")
    public int deleteCategory(@RequestBody Category category){
        return categoryService.deleteCategory(category);
    }



}
