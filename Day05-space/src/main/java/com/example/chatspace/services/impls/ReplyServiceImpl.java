package com.example.chatspace.services.impls;

import com.example.ssm.UnableFindException;
import com.example.chatspace.dao.impls.ReplyDaoImpl;
import com.example.chatspace.dao.pojo.HostReply;
import com.example.chatspace.dao.pojo.Reply;
import com.example.chatspace.dao.pojo.Topic;
import com.example.chatspace.services.norm.ReplyServiceNorm;
import com.example.ssm.utils.ConnectionUtil;

import java.sql.Connection;
import java.util.List;

public class ReplyServiceImpl implements ReplyServiceNorm {
    ReplyDaoImpl replyDao;

    //同层互助
    UserBasicServiceImpl userBasicService;
    HostReplyServiceImpl hostReplyService;

    @Override
    public List<Reply> getReplies(Integer idd) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        List<Reply> allReply = replyDao.find_AllReply(connection, new Topic() {
            @Override
            public void setId(Integer id) {
                super.setId(idd);
            }
        });
        if (allReply != null && allReply.size() > 0) {
            Integer[] ints = replyDao.getValues(connection,
                    Integer.class,
                    "author",
                    "SELECT * FROM t_reply");
            int index = 0;
            //设置每个回复对应的作者
            for (Reply reply : allReply) {
                reply.setUserBasic(userBasicService.getFriend(ints[index++]));
            }
            //获取并设置所有回复的主人回复
            for (Reply reply : allReply) {
                Integer id = reply.getId();
                HostReply hostReply = null;
                try {
                    hostReply = hostReplyService.getHostReply(id);
                } catch (UnableFindException e) {
                    System.out.println(reply.getContent() + " ----> " + e.getMessage());
                } finally {
                    if (hostReply != null) {
                        reply.setHostReply(hostReply);
                    }
                }
            }
        }
        return allReply;
    }

    @Override
    public boolean addReply(Reply reply) throws Exception {
        return replyDao.add_Reply(ConnectionUtil.getConnection(), reply);
    }

    public boolean delReply(Integer id) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        try {
            if (hostReplyService.getHostReply(id) != null) {
                if (hostReplyService.delHostReply(id)) {
                    return replyDao.del_Reply(connection,id);
                } else {
                    throw new RuntimeException(">>> 删除主人回复失败");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return replyDao.del_Reply(connection,id);
    }
}
