package com.example.chatspace.controllers;

import com.example.chatspace.dao.pojo.Reply;
import com.example.chatspace.dao.pojo.Topic;
import com.example.chatspace.dao.pojo.UserBasic;
import com.example.chatspace.services.impls.ReplyServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class ReplyController {

    ReplyServiceImpl replyService;

    public String addReply(String content, Integer topicId, HttpServletRequest request) throws Exception {
        Reply newReply = new Reply(content,
                new Date(),
                (UserBasic) request.getSession().getAttribute("userBasic"),
                new Topic(topicId)
        );
        if (replyService.addReply(newReply)) {
            return "redirect:topic.do?operator=topicDetail&id=" + topicId;
        }
        return null;
    }

    public String delReply(Integer replyId, Integer topicId) throws Exception {
        if (replyService.delReply(replyId)) {
            return "redirect:topic.do?operator=topicDetail&id=" + topicId;
        }
        return null;
    }
}
