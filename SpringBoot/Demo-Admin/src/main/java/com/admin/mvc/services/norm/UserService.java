package com.admin.mvc.services.norm;

import com.admin.mvc.mappers.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findUsers();

    void addUser(User user);
}
