package com.example.chatspace.dao.pojo;

import java.util.Date;

public class Reply {
    private Integer id;
    private String content;
    private Date replyDate;
    private UserBasic userBasic;

    private Topic topic;//回复的话题
    private HostReply hostReply;//这个回复对应的主人回复

    public Reply() {
    }

    public Reply(String content, Date date, UserBasic author, Topic topic) {
        this.content = content;
        this.replyDate = date;
        this.userBasic = author;
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public UserBasic getUserBasic() {
        return userBasic;
    }

    public void setUserBasic(UserBasic userBasic) {
        this.userBasic = userBasic;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public HostReply getHostReply() {
        return hostReply;
    }

    public void setHostReply(HostReply hostReply) {
        this.hostReply = hostReply;
    }
}
