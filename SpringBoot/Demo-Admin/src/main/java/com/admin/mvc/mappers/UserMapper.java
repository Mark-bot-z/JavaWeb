package com.admin.mvc.mappers;

import com.admin.mvc.mappers.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/*
* @MapperScan("com.admin....mapper") 简化，其他的接口就可以不用标注@Mapper注解
* */
@Mapper
public interface UserMapper{

    List<User> getUsers();


    void addUser(User user);
}
