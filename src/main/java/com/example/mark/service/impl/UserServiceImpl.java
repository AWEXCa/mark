package com.example.mark.service.impl;

import com.example.mark.bean.User;
import com.example.mark.mapper.UserMapper;
import com.example.mark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String uname,String pwd){
        return userMapper.selectByUnameAndPwd(uname, pwd);
    }
    @Override
    public int register(User user){
        user.setUid(UUID.randomUUID().toString());
        user.setIsAdmin('0');
        user.setMoney(0.00);
        return userMapper.insert(user);
    }
}
