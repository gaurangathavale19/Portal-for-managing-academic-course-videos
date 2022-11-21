package com.example.css699.rowmapper;

import com.example.css699.dao.CategoryDao;
import com.example.css699.models.Category;
import com.example.css699.models.User;
import org.springframework.jdbc.core.RowMapper;

public class CategoryRowMapper {

    public CategoryRowMapper() {
    }

    public static final RowMapper<Category> lambda = (record, recordNumber) -> {
       Category category = new Category();
       category.setCatId(record.getInt("catId"));
       category.setCategoryName(record.getString("catname"));
       return category;
    };

}
