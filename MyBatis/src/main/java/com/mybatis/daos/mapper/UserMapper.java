package com.mybatis.daos.mapper;

import com.mybatis.daos.pojo.User;

import java.util.List;

public interface UserMapper {
    //添加用户
    int addUser();

    //修改用户信息
    int modifyUserInfo();

    User findUserByID();

    List<User> findAllUser();
}
