package com.mybatis.daos.mapper;

import com.mybatis.daos.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SqlMapper {
    //模糊查询
    List<User> getUserByLikeName(@Param("username") String username);

    //批量删除
    void delUsers(@Param("ids")String ids);

    //动态设置表名
    List<User> getUserByTableName(@Param("tableName") String tableName);

    //获取自增的id（主键回填）
    void addUser(User user);
}
