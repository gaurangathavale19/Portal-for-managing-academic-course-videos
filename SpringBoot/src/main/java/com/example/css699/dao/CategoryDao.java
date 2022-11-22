package com.example.css699.dao;

import com.example.css699.models.Category;
import com.example.css699.models.Comment;
import com.example.css699.queries.Queries;
import com.example.css699.rowmapper.CategoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CategoryDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public Category addCategory(Category category){
        jdbcTemplate.update(Queries.ADD_CATEGORY, category.getCategoryName(), new Date(System.currentTimeMillis()));
        System.out.println("Category Added");
        return category;

    }

    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        categories =  jdbcTemplate.query(Queries.GET_ALL_CATEGORIES, CategoryRowMapper.lambda);
        return categories;
    }

    public Category getCategoryNameFromCategoryId(int categoryId){
        Category category = jdbcTemplate.query(Queries.GET_CATEGORY_NAME_FROM_CATEGORY_ID, CategoryRowMapper.lambda, categoryId).get(0);
        return category;
    }
}
