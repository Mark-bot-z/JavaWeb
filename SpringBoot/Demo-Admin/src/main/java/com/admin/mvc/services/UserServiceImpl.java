package com.admin.mvc.services;

import com.admin.mvc.mappers.UserMapper;
import com.admin.mvc.mappers.pojo.User;
import com.admin.mvc.services.norm.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserMapper userMapper;

    @Override
    public List<User> findUsers() {
        return userMapper.getUsers();
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
