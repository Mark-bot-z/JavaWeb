package com.example.chatspace.controllers;

import com.example.chatspace.dao.pojo.UserBasic;
import com.example.chatspace.services.impls.TopicServiceImpl;
import com.example.chatspace.services.impls.UserBasicServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class UserController {
    UserBasicServiceImpl userBasicService;
    TopicServiceImpl topicService;

    public String login(String loginID , String password , HttpServletRequest request) throws Exception{
        UserBasic userBasic;
        if ((userBasic = userBasicService.login(loginID,password)) != null) {
            userBasic.setTopicList(topicService.getTopics(userBasic));
            request.getSession().setAttribute("userBasic",userBasic);
            request.getSession().setAttribute("friend",userBasic);//一个变动的userBasic对象
            return "html:index";
        }
        return "html:login";
    }

    public String inFriendFrame(Integer friendID , HttpServletRequest request) throws Exception{
        UserBasic friend;
        if ((friend = userBasicService.getFriend(friendID)) != null){
            //设置朋友的日志
            friend.setTopicList(topicService.getTopics(friend));
            request.getSession().setAttribute("friend",friend);//更新朋友列表
            return "html:index";
        }
        return null;
    }


}
