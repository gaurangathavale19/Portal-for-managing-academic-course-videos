package com.example.css699.rowmapper;

import com.example.css699.models.Category;
import com.example.css699.models.Comment;
import org.springframework.jdbc.core.RowMapper;

public class CommentRowMapper {

    public CommentRowMapper() {
    }

    public static final RowMapper<Comment> lambda = (record, recordNumber) -> {
        Comment comment = new Comment();
        comment.setCommentId(record.getInt("commentId"));
        comment.setCommentString(record.getString("comment"));
        comment.setVidId(record.getInt("vidId"));
        comment.setCommentorId(record.getInt("commentorid"));
        comment.setCommentedOn(record.getDate("commentedOn"));
        return comment;
    };

}
