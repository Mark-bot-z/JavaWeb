package com.spring.mvc.services;

import com.spring.aopprinciple.DynamicProxy;
import com.spring.mvc.services.norm.UserServiceNorm;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    void login() {
        UserServiceNorm userService = new UserService();
        UserServiceNorm proxy = DynamicProxy.createProxy(userService);
        System.out.println(proxy.login());
    }
}