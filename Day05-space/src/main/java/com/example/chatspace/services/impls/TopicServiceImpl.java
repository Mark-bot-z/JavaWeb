package com.example.chatspace.services.impls;

import com.example.chatspace.dao.impls.TopicDaoImpl;
import com.example.chatspace.dao.pojo.Reply;
import com.example.chatspace.dao.pojo.Topic;
import com.example.chatspace.dao.pojo.UserBasic;
import com.example.chatspace.services.norm.TopicServiceNorm;
import com.example.ssm.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TopicServiceImpl implements TopicServiceNorm {
    TopicDaoImpl topicDao;

    ReplyServiceImpl replyService;
    UserBasicServiceImpl userBasicService;

    @Override
    public List<Topic> getTopics(UserBasic userBasic) throws SQLException {
        List<Topic> topicList;
        Connection connection = ConnectionUtil.getConnection();
        if ((topicList = topicDao.find_AllTopic(connection, userBasic.getId())) != null) {
            return topicList;
        }
        return null;
    }

    @Override
    public Topic getTopic(Integer id) throws SQLException {
        Topic topic;
        Connection connection = ConnectionUtil.getConnection();
        if ((topic = topicDao.find_Topic(connection, id)) != null) {
            try {
                List<Reply> reply;
                if ((reply = replyService.getReplies(id)) != null) {
                    //设置所有的回复
                    topic.setReplies(reply);
                    //设置话题的作者
                    topic.setUser_Author(userBasicService.getFriend(topic.getAuthor()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return topic;
        }
        return null;
    }

    @Override
    public boolean deTopic(Integer id) throws Exception {
        List<Reply> replies = replyService.getReplies(id);
        if (replies != null) {
            for (Reply reply : replies) {
                replyService.delReply(reply.getId());
            }
        }
        return topicDao.del_Topic(ConnectionUtil.getConnection(),new Topic(){
            @Override
            public void setId(Integer idd) {
                super.setId(id);
            }
        });
    }
}
