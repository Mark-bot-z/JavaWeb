package com.example.chatspace.controllers;

import com.example.chatspace.dao.pojo.Topic;
import com.example.chatspace.dao.pojo.UserBasic;
import com.example.chatspace.services.impls.TopicServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TopicController {
    TopicServiceImpl topicService;

    public String topicDetail(Integer id, HttpServletRequest request) throws Exception{
        Topic topic;
        if ((topic = topicService.getTopic(id)) != null){
            request.getSession().setAttribute("topic",topic);
            return "html:frames/detail";
        }
        return  null;
    }

    public String delTopic(Integer topicId) throws Exception{
        if (topicService.deTopic(topicId)) {
            return "redirect:topic.do?operator=updateTopicList";
        }
        throw new RuntimeException("删除失败");
    }

    public String updateTopicList(HttpServletRequest request) throws Exception{
        UserBasic userBasic = (UserBasic)request.getSession().getAttribute("userBasic");
        List<Topic> topics = topicService.getTopics(userBasic);
        userBasic.setTopicList(topics);
        request.getSession().setAttribute("friend",userBasic);
        return "html:frames/main";
    }
}
