package com.example.css699.service.serviceImpl;


import com.example.css699.dao.CategoryDao;
import com.example.css699.models.Category;
import com.example.css699.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    public CategoryDao categoryDao;

    public Category addCategory(Category category){
        return categoryDao.addCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
