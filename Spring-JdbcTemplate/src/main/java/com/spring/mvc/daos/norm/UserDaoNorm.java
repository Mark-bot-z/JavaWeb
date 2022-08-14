package com.spring.mvc.daos.norm;

import com.spring.mvc.daos.pojo.User;

import java.util.List;

public interface UserDaoNorm {

    boolean addUser(User user);

    boolean addUser(List<User> users);

    boolean updateUser(Integer id , User newUserInfo);

    boolean updateUser(List<User> newUserInfos);

    boolean delUserOfID(Integer id);

    boolean delUserOfID(List<User> users);
//    聚合
    int selectUserCount();

    User selectUserInfo(Integer userID);

    List<User> selectUsersInfo();
}
