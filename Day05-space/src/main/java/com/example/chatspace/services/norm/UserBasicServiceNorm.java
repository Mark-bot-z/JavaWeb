package com.example.chatspace.services.norm;

import com.example.chatspace.dao.pojo.UserBasic;

import java.util.List;

public interface UserBasicServiceNorm {
    //登录
    UserBasic login(String loginID , String password) throws Exception;

    //获取朋友列表
    UserBasic getFriend(Integer friendID) throws Exception;
}
