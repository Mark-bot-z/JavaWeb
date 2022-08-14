package com.example.book.services.impls;

import com.example.book.dao.impls.UserDaoImpl;
import com.example.book.dao.pojo.User;
import com.example.book.services.norm.UserServiceNorm;
import com.example.ssm.utils.ConnectionUtil;

import java.sql.Connection;

public class UserServiceImpl implements UserServiceNorm {
    UserDaoImpl userDao;

    @Override
    public User getUser(User user) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        return userDao.find_User(connection, user);
    }
}
