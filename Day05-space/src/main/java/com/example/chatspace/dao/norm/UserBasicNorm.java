package com.example.chatspace.dao.norm;

import com.example.ssm.UnableFindException;
import com.example.chatspace.dao.pojo.UserBasic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserBasicNorm {

    /**
     * 查找指定账号和密码相同的用户信息
     *
     * @param loginID  账号
     * @param password 密码
     * @return 用户的基本信息
     * @throws UnableFindException 找不到抛出这个异常
     */
    UserBasic find_UserBasic(Connection connection ,String loginID, String password) throws SQLException, UnableFindException;

    /**
     * 根据id查找指定的用户
     *
     * @param friendID 朋友的id
     * @return 返回一个用户基本信息
     * @throws UnableFindException 找不到抛出这个异常
     */
    UserBasic find_UserBasicByID(Connection connection ,Integer friendID) throws SQLException , UnableFindException;

    /**
     * 获取指定用户的所有好友
     *
     * @return 返回一个好友列表
     */
    List<UserBasic> find_AllFriendOfSpecify(Connection connection ,UserBasic userBasic) throws SQLException;

}
