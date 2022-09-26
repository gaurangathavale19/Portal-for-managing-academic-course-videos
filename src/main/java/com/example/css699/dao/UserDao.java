package com.example.css699.dao;

import com.example.css699.models.User;
import com.example.css699.queries.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public User addUser(User user){
        jdbcTemplate.update(Queries.ADD_USER, user.getName(), user.getEmailId(), user.getUserName(), user.getPassword());
        System.out.println("Inserted the user");
        return user;
    }
}
