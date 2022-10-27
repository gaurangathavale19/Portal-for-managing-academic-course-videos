package com.example.css699.models;

import java.util.Date;

public class Video {
    private int vidId;
    private String vidName;
    private String vidDescription;
    private String vidPath;
    private Date uploadedOn;
    private String status;
    private int creatorId;
    private int likes;
    public int getVidId() {
        return vidId;
    }

    public void setVidId(int vidId) {
        this.vidId = vidId;
    }

    public String getVidName() {
        return vidName;
    }

    public void setVidName(String vidName) {
        this.vidName = vidName;
    }

    public String getVidDescription() {
        return vidDescription;
    }

    public void setVidDescription(String vidDescription) {
        this.vidDescription = vidDescription;
    }

    public String getVidPath() {
        return vidPath;
    }

    public void setVidPath(String vidPath) {
        this.vidPath = vidPath;
    }

    public Date getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(Date uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreator() {
        return creatorId;
    }

    public void setCreator(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
