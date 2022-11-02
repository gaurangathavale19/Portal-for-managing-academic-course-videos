package com.example.css699.controllers;

import com.example.css699.models.Comment;
import com.example.css699.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
}
