package com.example.css699.dao;

import com.example.css699.models.User;
import com.example.css699.queries.Queries;
import com.example.css699.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public User addUser(User user){
        List<User> userFromDatabase = jdbcTemplate.query(Queries.GET_USER_BY_USERNAME, UserRowMapper.lambda, user.getUserName());
        if(userFromDatabase.size() == 1){
            System.out.println("User already exists! Please try to sign in!!");
            return null;
        }
        jdbcTemplate.update(Queries.ADD_USER, user.getName(), user.getEmailId(), user.getUserName(), user.getPassword());
        List<User> insertedUser = jdbcTemplate.query(Queries.GET_USER_BY_USERNAME, UserRowMapper.lambda, user.getUserName());
        user.setUserId(insertedUser.get(0).getUserId());
        System.out.println("Inserted the user");
        return user;
    }

    public User signIn(User user){
        List<User> userFromDatabase = jdbcTemplate.query(Queries.GET_USER_BY_USERNAME, UserRowMapper.lambda, user.getUserName());
        if (userFromDatabase != null && userFromDatabase.size()!=0 && userFromDatabase.get(0).getPassword().equals(user.getPassword())){
            System.out.println("User "+ user.getUserName() +" logged in Successfully");
            return user;
        }
        else{
            System.out.println("Invalid Credentials");
            return null;
        }
    }
}
