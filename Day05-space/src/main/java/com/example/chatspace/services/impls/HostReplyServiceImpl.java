package com.example.chatspace.services.impls;

import com.example.ssm.UnableFindException;
import com.example.chatspace.dao.impls.HostReplyDaoImpl;
import com.example.chatspace.dao.pojo.HostReply;
import com.example.chatspace.services.norm.HostReplyServiceNorm;
import com.example.ssm.utils.ConnectionUtil;

import java.sql.Connection;

public class HostReplyServiceImpl implements HostReplyServiceNorm {
    HostReplyDaoImpl hostReplyDao;

    @Override
    public HostReply getHostReply(Integer ID) throws Exception {
        HostReply hostReply;
        Connection connection = ConnectionUtil.getConnection();
        if ((hostReply = hostReplyDao.find_HostReply(connection,ID) )!= null){
            return hostReply;
        }
        throw new UnableFindException("没有对应的主人回复");
    }

    public boolean delHostReply(Integer ID) throws Exception {
        return hostReplyDao.del_HostReply(ConnectionUtil.getConnection() , ID);
    }
}
