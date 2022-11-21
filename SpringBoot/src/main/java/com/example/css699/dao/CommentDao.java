package com.example.css699.dao;

import com.example.css699.models.Comment;
import com.example.css699.queries.Queries;
import com.example.css699.rowmapper.CommentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CommentDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public Comment addComment(Comment comment){
        jdbcTemplate.update(Queries.ADD_COMMENT, comment.getCommentString(), new Date(System.currentTimeMillis()), comment.getCommentorId(), comment.getVidId());
        System.out.println("Comment Added Sucessfully");
        return comment;
    }

    public List<Comment> getCommentByVidId(int vidId){
        List<Comment> comments = jdbcTemplate.query(Queries.GET_COMMENT_BY_VID_ID, CommentRowMapper.lambda, vidId);
        return comments;
    }

}
