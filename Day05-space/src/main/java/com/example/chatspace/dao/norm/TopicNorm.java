package com.example.chatspace.dao.norm;

import com.example.chatspace.dao.pojo.Topic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TopicNorm {

    /**
     * 获取指定用户的所有话题集合
     *
     * @param author 指定用户(作者)的id
     * @return 返回所有话题集合
     */
    List<Topic> find_AllTopic(Connection connection, Integer author) throws SQLException;

    /**
     * 添加话题
     *
     * @param topic 话题类的实体
     * @return 添加是否成功
     */
    boolean add_Topic(Connection connection,Topic topic) throws SQLException;

    /**
     * 删除话题
     *
     * @param topic 话题类的实体
     * @return 删除是否成功
     */
    boolean del_Topic(Connection connection,Topic topic) throws SQLException;

    /**
     * 获取指定的话题信息
     *
     * @param ID ID
     * @return 话题类的实体所携带的具体信息
     */
    Topic find_Topic(Connection connection,Integer ID) throws SQLException;

}
