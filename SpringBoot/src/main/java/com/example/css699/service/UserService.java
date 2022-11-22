package com.example.css699.service;

import com.example.css699.models.User;

public interface UserService {
    public User addUser(User user);
    public User signIn(User user);
    public boolean isAdmin(int userId);


}
