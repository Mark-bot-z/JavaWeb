package com.example.chatspace.dao.impls;

import com.example.chatspace.dao.norm.ReplyNorm;
import com.example.chatspace.dao.pojo.Reply;
import com.example.chatspace.dao.pojo.Topic;
import com.example.ssm.base.BaseMeans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ReplyDaoImpl extends BaseMeans<Reply> implements ReplyNorm {
    @Override
    public List<Reply> find_AllReply(Connection connection, Topic topic) throws SQLException {
        topic.setId(0);
        List<Reply> replies = super.selectRecordMany(connection,
                "SELECT id,content,replyDate FROM t_reply WHERE topic = ?", topic.getId());
        if (replies.size() > 0){
            return replies;
        }
        return null;
    }

    @Override
    public boolean add_Reply(Connection connection, Reply reply) throws SQLException {
        return super.addRecord(connection,
                "INSERT INTO t_reply VALUES (0,?,?,?,?)",
                reply.getContent(),
                reply.getReplyDate(),
                reply.getUserBasic().getId(),
                reply.getTopic().getId()
        ) > 0;
    }

    public boolean del_Reply(Connection connection, Integer id) throws SQLException{
        return super.deleteRecord(connection, "DELETE FROM t_reply WHERE id = ?", id) > 0;
    }
}
