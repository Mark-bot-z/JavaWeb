package com.mybatis.daos.mapper;

import com.mybatis.daos.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ParameterMapper {
    User getUserByName(String name);

    User check(String name,String password);

    User checkLoginByUser(@Param("user") User user);

//    User checkLoginByMap(Map<String,Object> map);

    Integer modifyUserByID(@Param("id") Integer id, @Param("password") String password);
}
