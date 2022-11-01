package com.example.css699.dao;

import com.example.css699.models.Category;
import com.example.css699.models.Comment;
import com.example.css699.queries.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Repository
public class CategoryDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public Category addCategory(Category category){
        jdbcTemplate.update(Queries.ADD_CATEGORY, category.getCategory(), new Date(System.currentTimeMillis()));
        System.out.println("Category Added");
        return category;

    }

//    return null;
}