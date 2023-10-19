package com.example.mark.service;

import com.example.mark.bean.User;

public interface UserService {
    public User login(String uname, String pwd);

    int register(User user);
}
