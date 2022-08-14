package com.spring.mvc.services;

import com.spring.mvc.services.norm.UserServiceNorm;

public class UserService implements UserServiceNorm {

    @Override
    public boolean login() {
        System.out.println("现在是登录失败的 <-----");
        return false;
    }
}
