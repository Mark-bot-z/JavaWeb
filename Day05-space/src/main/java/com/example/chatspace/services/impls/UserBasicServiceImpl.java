package com.example.chatspace.services.impls;

import com.example.chatspace.dao.impls.UserBasicDaoImpl;
import com.example.chatspace.dao.pojo.UserBasic;
import com.example.chatspace.services.norm.UserBasicServiceNorm;
import com.example.ssm.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserBasicServiceImpl implements UserBasicServiceNorm {
    UserBasicDaoImpl userBasicDao;
    @Override
    public UserBasic login(String loginID, String password) throws Exception {
        UserBasic userBasic;
        Connection connection = ConnectionUtil.getConnection();
        if ((userBasic = userBasicDao.find_UserBasic(connection,loginID, password)) != null){
            fillFriends(userBasic, connection);
            return userBasic;
        }
        return null;
    }

    //查找并填充所有的朋友
    synchronized void fillFriends(UserBasic userBasic, Connection connection) throws SQLException {
        List<UserBasic> allFriendOfSpecify = userBasicDao.find_AllFriendOfSpecify(connection, userBasic);
        userBasic.setFriendList(allFriendOfSpecify);
    }

    @Override
    public UserBasic getFriend(Integer friendID) throws Exception {
        UserBasic userBasic;
        Connection connection = ConnectionUtil.getConnection();
        if ((userBasic = userBasicDao.find_UserBasicByID(connection,friendID))!= null){
            fillFriends(userBasic,connection);
            return userBasic;
        }
        return null;
    }
}
