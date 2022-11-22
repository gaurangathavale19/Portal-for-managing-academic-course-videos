package com.example.css699.queries;

public class Queries {
    public Queries() {

    }

    public static final String ADD_USER = "INSERT INTO USER1 (name, email, username, password) VALUES (?,?,?,?)";
    public static final String GET_USER_BY_USERNAME = "SELECT * FROM USER1 WHERE username = ?";
    public static final String GET_VIDEO_BY_PATH_NAME = "SELECT * FROM VIDEO WHERE vidPath = ?";
    public static final String UPLOAD_VIDEO = "INSERT INTO VIDEO (vidPath) VALUES (?)";
    public static final String UPDATE_VIDEO_DATA = "UPDATE VIDEO SET vidName = ?, vidDescription = ?, creatorid = ?, catid = ?, uploadedOn = ?, status = 'PENDING', likes = 0 WHERE vidId = ?";
    public static final String GET_ALL_APPROVED_VIDEOS = "SELECT * FROM VIDEO where status = 'APPROVED'";
    public static final String GET_ALL_PENDING_VIDEOS = "SELECT * FROM VIDEO where status = 'PENDING'";
    public static final String GET_MY_VIDEOS = "SELECT * FROM VIDEO WHERE creatorid = (SELECT userid FROM USER1 WHERE username = ?)";
    public static final String GET_VIDEO_BY_VIDEO_ID = "SELECT * FROM VIDEO WHERE vidId = ?";
    public static final String GET_CREATOR_NAME_FROM_CREATOR_ID = "SELECT * FROM USER1 WHERE userid = ?";
    public static final String LIKE_A_VIDEO = "UPDATE VIDEO SET likes = likes + 1 WHERE vidid = ?";
    public static final String ADD_A_LIKE = "INSERT INTO LIKE1 (likedOn, userId, vidId) VALUES (?,?,?)";
    public static final String UNLIKE_A_VIDEO = "UPDATE VIDEO SET likes = likes - 1 WHERE vidid = ?";
    public static final String REMOVE_A_LIKE = "DELETE FROM LIKE1 WHERE userId = ? and vidId = ?";
    public static final String CHECK_IF_VID_LIKED_BY_USER = "SELECT * FROM LIKE1 WHERE userId = ? and vidId = ?";
    public static final String ADD_COMMENT = "INSERT INTO COMMENT(comment, commentedon, commentorid, vidid) VALUES (?,?,?,?)";
    public static final String ADD_CATEGORY = "INSERT INTO CATEGORY(catName, createdon) VALUES (?,?)";
    public static final String GET_ALL_CATEGORIES = "SELECT * FROM CATEGORY";
    public static final String GET_COMMENT_BY_VID_ID = "SELECT * FROM COMMENT WHERE vidId = ?";
    public static final String GET_CATEGORY_NAME_FROM_CATEGORY_ID = "SELECT * FROM CATEGORY WHERE catId = ?";
    public static final String CHECK_IF_USER_IS_ADMIN = "SELECT * FROM USER1 WHERE userId = ?";
    public static final String EDIT_VIDEO_BOTH_FIELDS = "UPDATE VIDEO SET vidName = ?, vidDescription = ? where vidId = ?";
    public static final String EDIT_VIDEO_DESCRIPTION = "UPDATE VIDEO SET vidDescription = ? where vidId = ?";
    public static final String EDIT_VIDEO_NAME = "UPDATE VIDEO SET vidName = ? where vidId = ?";
    public static final String DELETE_VIDEO = "DELETE FROM VIDEO WHERE vidId = ?";

    public static final String SET_STATUS = "UPDATE VIDEO SET status = ? WHERE vidID = ? ";


}
