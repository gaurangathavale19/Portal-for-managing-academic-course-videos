package com.example.css699.models;

import java.util.Date;

public class Comment {

    private int commentid;

    private String comment;

    private Date commentedon;

    private int commentorid;

    private int vidid;

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentedon() {
        return commentedon;
    }

    public void setCommentedon(Date commentedon) {
        this.commentedon = commentedon;
    }

    public int getCommentorid() {
        return commentorid;
    }

    public void setCommentorid(int commentorid) {
        this.commentorid = commentorid;
    }

    public int getVidid() {
        return vidid;
    }

    public void setVidid(int vidid) {
        this.vidid = vidid;
    }
}
