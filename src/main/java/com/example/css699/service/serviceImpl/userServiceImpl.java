package com.example.css699.service.serviceImpl;

import com.example.css699.dao.UserDao;
import com.example.css699.models.User;
import com.example.css699.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User addUser(User user) {
        return userDao.addUser(user);
    }
}
