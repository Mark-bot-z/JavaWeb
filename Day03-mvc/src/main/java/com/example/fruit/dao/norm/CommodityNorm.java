package com.example.fruit.dao.norm;

import com.example.fruit.dao.pojo.Commodity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CommodityNorm {
    List<Commodity> find_ALLCommodity(Connection connection, String sql) throws SQLException;

    Commodity find_SingleCommodity(Connection connection ,String sql, int fid) throws SQLException;

    boolean set_Commodity(Connection connection ,String sql, Object... args) throws SQLException;

    boolean del_Commodity(Connection connection ,String sql, int fid) throws SQLException;

    boolean add_Commodity(Connection connection ,String sql, Object... args) throws SQLException;
    //分页查询
    List<Commodity> find_CommodityOfPage(Connection connection, String sql , int pageNo) throws SQLException;
}
