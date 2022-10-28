package com.example.css699.dao;

import com.example.css699.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public Comment addComment(Comment comment){
        return null;

    }

}
