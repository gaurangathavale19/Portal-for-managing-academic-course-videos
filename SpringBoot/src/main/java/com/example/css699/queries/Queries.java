package com.example.css699.queries;

public class Queries {
    public Queries() {

    }

    public static final String ADD_USER = "INSERT INTO USER1 (name, email, username, password) VALUES (?,?,?,?)";
    public static final String GET_USER_BY_USERNAME = "SELECT * FROM USER1 WHERE username = ?";
    public static final String GET_VIDEO_BY_PATH_NAME = "SELECT * FROM VIDEO WHERE vidPath = ?";
    public static final String UPLOAD_VIDEO = "INSERT INTO VIDEO (vidPath) VALUES (?)";
    public static final String UPDATE_VIDEO_DATA = "UPDATE VIDEO SET vidName = ?, vidDescription = ?, status = 'PENDING' WHERE vidId = ?";
    public static final String GET_ALL_APPROVED_VIDEOS = "SELECT * FROM VIDEO where status = 'APPROVED'";
    public static final String GET_ALL_PENDING_VIDEOS = "SELECT * FROM VIDEO where status = 'PENDING'";
    public static final String GET_MY_VIDEOS = "SELECT * FROM VIDEO WHERE creatorid = (SELECT userid FROM USER1 WHERE username = ?)";
    public static final String GET_VIDEO_BY_VIDEO_ID = "SELECT * FROM VIDEO WHERE vidId = ?";
    public static final String GET_CREATOR_NAME_FROM_CREATOR_ID = "SELECT * FROM USER1 WHERE userid = ?";
    public static final String LIKE_A_VIDEO = "UPDATE VIDEO SET likes = likes + 1 WHERE vidid = ?";

    public static final String ADD_COMMENT = "INSERT INTO COMMENT(comment, commentedon, commentorid, vidid) VALUES (?,?,?,?)";


}
