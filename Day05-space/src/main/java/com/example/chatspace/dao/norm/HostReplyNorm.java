package com.example.chatspace.dao.norm;

import com.example.ssm.UnableFindException;
import com.example.chatspace.dao.pojo.HostReply;

import java.sql.Connection;
import java.sql.SQLException;

public interface HostReplyNorm {
    /**
     * 根据某个回复的ID获取对应的主人回复
     *
     * @param ID 回复的ID
     * @return 主人回复
     */
    HostReply find_HostReply(Connection connection , Integer ID) throws SQLException , UnableFindException;
}
