package com.example.css699.service;

import com.example.css699.models.Category;

import java.util.List;

public interface CategoryService {

    public Category addCategory(Category category);

    public List<Category> getAllCategories();

    public Category getCategoryNameFromCategoryId(int categoryId);

}
