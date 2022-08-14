package com.mybatis.daos.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /*
    {password=111, sex=男, id=1, age=12, email=123@QQ.COM, username=ZHANG}
    * 针对于一条数据组成的map(由于插件的存在，会保存提示加MapKey注解)
    * */
    @MapKey("id")
    Map<?,?> getUserByID(@Param("ID") Integer ID);

    /*
    * 多条数据组成map集合，就需要指定其中某个字段作为键
    * */
    @MapKey("id")
    Map<? , ?> getAllUser();

    /*
    * 一条数据为一个map集合用Collection集合装载(由于插件的存在，会保存提示加MapKey注解)
    * */
    @MapKey("id")
    List<Map<?,?>> getAllUserToList();








}
