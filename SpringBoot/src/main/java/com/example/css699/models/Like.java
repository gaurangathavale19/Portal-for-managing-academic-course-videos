package com.example.css699.models;

import java.util.Date;

public class Like {

    private int likeId;
    private Date likedOn;
    private int userId;
    private int vidId;

    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    public Date getLikedOn() {
        return likedOn;
    }

    public void setLikedOn(Date likedOn) {
        this.likedOn = likedOn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVidId() {
        return vidId;
    }

    public void setVidId(int vidId) {
        this.vidId = vidId;
    }
}

