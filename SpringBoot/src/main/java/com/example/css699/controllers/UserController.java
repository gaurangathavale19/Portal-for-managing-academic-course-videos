package com.example.css699.controllers;

import com.example.css699.models.User;
import com.example.css699.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @CrossOrigin(origins="http://localhost:4200")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/signIn")
    @CrossOrigin(origins="http://localhost:4200")
    public User signIn(@RequestBody User user){
        System.out.println(user.getUserName());
        return userService.signIn(user);
    }

}