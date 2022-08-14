package com.example.chatspace.dao.impls;

import com.example.chatspace.dao.norm.TopicNorm;
import com.example.chatspace.dao.pojo.Topic;
import com.example.ssm.base.BaseMeans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TopicDaoImpl extends BaseMeans<Topic> implements TopicNorm {

    @Override
    public List<Topic> find_AllTopic(Connection connection, Integer author) throws SQLException {
        List<Topic> topics = this.selectRecordMany(connection,
                "SELECT * FROM t_topic WHERE author = ? ", author);
        if (topics.size() == 0) {
            return null;
        }
        return topics;
    }

    @Override
    public boolean add_Topic(Connection connection, Topic topic) {
        throw new RuntimeException("TopicDaoImpl ---> add_Topic 未实现");
    }

    @Override
    public boolean del_Topic(Connection connection, Topic topic) throws SQLException {
        topic.setId(0);
        return super.deleteRecord(connection,"DELETE FROM t_topic WHERE id = ?",topic.getId()) > 0;
    }

    @Override
    public Topic find_Topic(Connection connection, Integer ID) throws SQLException {
        Topic topic;
        if ((topic = super.selectRecordSingle(connection,
                "SELECT * FROM t_topic WHERE id = ?", ID)) != null) {
            return topic;
        }
        return null;
    }
}
