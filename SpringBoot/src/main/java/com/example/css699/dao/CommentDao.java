package com.example.css699.dao;

import com.example.css699.models.Comment;
import com.example.css699.queries.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public Comment addComment(Comment comment){
        jdbcTemplate.update(Queries.ADD_COMMENT, comment.getComment(), comment.getCommentedon(), comment.getCommentorid(), comment.getVidid());
        System.out.println("Comment Added Sucessfully");
        return comment;


//        return null;

    }

}
