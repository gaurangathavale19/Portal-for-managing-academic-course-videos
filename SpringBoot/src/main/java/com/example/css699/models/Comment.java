package com.example.css699.models;

import java.util.Date;

public class Comment {

    private int commentId;

    private String commentString;

    private Date commentedOn;

    private int commentorId;

    private int vidId;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentString() {
        return commentString;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
    }

    public Date getCommentedOn() {
        return commentedOn;
    }

    public void setCommentedOn(Date commentedOn) {
        this.commentedOn = commentedOn;
    }

    public int getCommentorId() {
        return commentorId;
    }

    public void setCommentorId(int commentorId) {
        this.commentorId = commentorId;
    }

    public int getVidId() {
        return vidId;
    }

    public void setVidId(int vidId) {
        this.vidId = vidId;
    }
}
