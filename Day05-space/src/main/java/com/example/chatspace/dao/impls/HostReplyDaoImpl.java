package com.example.chatspace.dao.impls;

import com.example.ssm.UnableFindException;
import com.example.chatspace.dao.norm.HostReplyNorm;
import com.example.chatspace.dao.pojo.HostReply;
import com.example.ssm.base.BaseMeans;

import java.sql.Connection;
import java.sql.SQLException;

public class HostReplyDaoImpl extends BaseMeans<HostReply> implements HostReplyNorm {
    @Override
    public HostReply find_HostReply(Connection connection, Integer ID) throws SQLException, UnableFindException {
        HostReply hostReply;
        if ((hostReply = super.selectRecordSingle(connection, "SELECT * FROM t_host_reply WHERE reply = ?", ID)) != null) {
            return hostReply;
        }
        throw new UnableFindException("没有主人回复");
    }

    public  boolean del_HostReply(Connection connection , Integer ID) throws SQLException{
       return super.deleteRecord(connection , "DELETE FROM t_host_reply WHERE reply = ?",ID) > 0;
    }
}
