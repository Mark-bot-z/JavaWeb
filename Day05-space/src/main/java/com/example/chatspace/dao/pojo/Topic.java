package com.example.chatspace.dao.pojo;

import java.util.Date;
import java.util.List;

public class Topic {
    private Integer id;
    private String title;
    private String content;
    private Date topicDate;
    private UserBasic user_Author;
    private Integer author;

    public Topic(Integer id){
        this.id = id;
    }

    private List<Reply> replies;//话题的回复集合


    public Topic (){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(Date topicDate) {
        this.topicDate = topicDate;
    }


    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public UserBasic getUser_Author() {
        return user_Author;
    }

    public void setUser_Author(UserBasic user_Author) {
        this.user_Author = user_Author;
    }
}
