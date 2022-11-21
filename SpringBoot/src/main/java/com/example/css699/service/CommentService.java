package com.example.css699.service;

import com.example.css699.models.Comment;

import java.util.List;

public interface CommentService {

    public Comment addComment(Comment comment);

    public List<Comment> getCommentByVidId(int vidId);
}
