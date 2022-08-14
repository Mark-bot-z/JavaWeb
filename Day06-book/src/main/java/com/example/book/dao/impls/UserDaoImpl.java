package com.example.book.dao.impls;

import com.example.book.dao.norm.UserDaoNorm;
import com.example.book.dao.pojo.User;
import com.example.ssm.base.BaseMeans;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl extends BaseMeans<User> implements UserDaoNorm {

    @Override
    public User find_User(Connection connection, User user) throws SQLException{
        User single;
        return (single = super.selectRecordSingle(connection,
                "SELECT * FROM t_user WHERE uname = ? AND pwd = ?",
                user.getUname(),
                user.getPwd()
        )) != null ? single : null;
    }
}
