package com.example.css699.controllers;

import com.example.css699.models.User;
import com.example.css699.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

}