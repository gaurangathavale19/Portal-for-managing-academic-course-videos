package com.example.css699.queries;

public class Queries {
    public Queries() {

    }

    public static final String ADD_USER = "INSERT INTO USER1 (name, email, username, password) VALUES (?,?,?,?)";

    public static final String UPLOAD_VIDEO = "INSERT INTO VIDEO (vidName, vidDescription, vidPath, isApproved, uploadedOn) VALUES (?,?,?,?,?)";

}
