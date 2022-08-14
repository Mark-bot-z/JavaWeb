package com.example.chatspace.dao.norm;

import com.example.chatspace.dao.pojo.Reply;
import com.example.chatspace.dao.pojo.Topic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ReplyNorm {

    /**
     * 根据话题获取回复集合
     *
     * @param topic 话题对象
     *
     * @return 回复集合
     */
    List<Reply> find_AllReply(Connection connection,Topic topic) throws SQLException;

    /**
     * 添加回复
     *
     * @param reply 回复对象
     *
     * @return 回复成功为true
     */
    boolean add_Reply(Connection connection ,Reply reply) throws SQLException;
}
