package com.example.css699.controllers;

import com.example.css699.models.Comment;
import com.example.css699.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    @CrossOrigin(origins = "http://localhost:4200")
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @GetMapping("/getCommentByVidId/{vidId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Comment> getCommentByVidId(@PathVariable int vidId){
        return commentService.getCommentByVidId(vidId);
    }
}
