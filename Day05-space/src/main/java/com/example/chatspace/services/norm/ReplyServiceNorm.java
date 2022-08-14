package com.example.chatspace.services.norm;

import com.example.chatspace.dao.pojo.Reply;

import java.sql.Connection;
import java.util.List;

public interface ReplyServiceNorm {

    //根据话题id获取所有的回复
    List<Reply> getReplies(Integer id) throws Exception;

    boolean addReply(Reply reply) throws Exception;
}
