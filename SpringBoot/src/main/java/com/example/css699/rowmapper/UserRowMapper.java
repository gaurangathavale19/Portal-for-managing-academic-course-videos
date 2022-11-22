package com.example.css699.rowmapper;

import com.example.css699.models.User;
import org.springframework.jdbc.core.RowMapper;


public class UserRowMapper {

    public UserRowMapper() {
    }

    public static final RowMapper<User> lambda = (record, recordNumber) -> {
        User user = new User();
        user.setUserId(record.getInt("userId"));
        user.setUserName(record.getString("userName"));
        user.setName(record.getString("name"));
        user.setEmailId(record.getString("email"));
        user.setPassword(record.getString("password"));
        user.setAdmin(record.getBoolean("isAdmin"));
        return user;
    };

}
