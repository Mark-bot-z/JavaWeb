package com.admin.mvc.controllers;

import com.admin.mvc.mappers.pojo.User;
import com.admin.mvc.services.norm.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/testFindAllRecord")
    @ResponseBody
    public List<User> testFindAllRecord(){
        return userService.findUsers();
    }

    @RequestMapping(value = "/testAddRecord")
    @ResponseBody
    public User testAddRecord(User user){
        userService.addUser(user);
        return user;
    }

    /*
    *   1.引入mybatis-starter
        2.配置application.yaml中，指定mapper-location位置即可
        3.编写Mapper接口并标注@Mapper注解
        4.简单方法直接注解方式
        5.复杂方法编写mapper.xml进行绑定映射
    *
    * */





}
