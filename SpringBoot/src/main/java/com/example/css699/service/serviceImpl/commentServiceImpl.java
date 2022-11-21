package com.example.css699.service.serviceImpl;

import com.example.css699.dao.CommentDao;
import com.example.css699.models.Comment;
import com.example.css699.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentServiceImpl implements CommentService {

    @Autowired
    public CommentDao commentDao;

    public Comment addComment(Comment comment){
        return commentDao.addComment(comment);
    }

    @Override
    public List<Comment> getCommentByVidId(int vidId) {
        return commentDao.getCommentByVidId(vidId);
    }


}
