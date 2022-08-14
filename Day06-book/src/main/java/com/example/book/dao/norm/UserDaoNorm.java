package com.example.book.dao.norm;

import com.example.book.dao.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDaoNorm {

    /**
     * 根据只指定的条件来寻找用户
     *
     * @param user 只需要提供账号和密码
     * @return 返回这个用户
     */
    User find_User(Connection connection, User user) throws SQLException;
}
