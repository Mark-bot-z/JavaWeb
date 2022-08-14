package com.example.chatspace.services.norm;

import com.example.chatspace.dao.pojo.Topic;
import com.example.chatspace.dao.pojo.UserBasic;
import com.example.chatspace.services.impls.TopicServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TopicServiceNorm {
    //获取用户的所有日志
    List<Topic> getTopics(UserBasic userBasic) throws SQLException;

    //获取用户的单个日志
    Topic getTopic(Integer id) throws SQLException;

    //删除单个日志
    boolean deTopic(Integer id) throws Exception;

}
