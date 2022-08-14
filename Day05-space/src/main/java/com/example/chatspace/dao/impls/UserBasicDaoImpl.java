package com.example.chatspace.dao.impls;

import com.example.ssm.UnableFindException;
import com.example.chatspace.dao.norm.UserBasicNorm;
import com.example.chatspace.dao.pojo.UserBasic;
import com.example.ssm.base.BaseMeans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserBasicDaoImpl extends BaseMeans<UserBasic> implements UserBasicNorm {
    @Override
    public UserBasic find_UserBasic(Connection connection ,String loginID, String password) throws SQLException, UnableFindException {
        UserBasic userBasic = this.selectRecordSingle(connection,
                "SELECT * FROM t_user_basic WHERE loginId = ? AND pwd = ?",
                loginID,
                password);
        if (userBasic != null){
            return userBasic;
        }
        throw new UnableFindException("没有该用户的信息！");
    }

    @Override
    public UserBasic find_UserBasicByID(Connection connection ,Integer friendID) throws SQLException, UnableFindException {
        UserBasic userBasic = this.selectRecordSingle(connection,
                "SELECT * FROM t_user_basic WHERE id = ?", friendID);
        if (userBasic != null){
            return userBasic;
        }
        throw new UnableFindException("没有该用户的信息！");
    }

    @Override
    public List<UserBasic> find_AllFriendOfSpecify(Connection connection ,UserBasic userBasic) throws SQLException  {
        String sql = "SELECT * " +
                     "FROM t_user_basic JOIN (SELECT fid " +
                     "                             FROM t_friend WHERE uid = ?) t1 ON t1.fid = t_user_basic.id ";
        List<UserBasic> userBasics = this.selectRecordMany(connection, sql, userBasic.getId());
        if (userBasics.size() == 0){
            return null;
        }
        return userBasics;
    }
}
