package com.example.fruit.dao.impls;

import com.example.fruit.dao.norm.CommodityNorm;
import com.example.fruit.pojo.Commodity;
import com.example.ssm.base.BaseMeans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CommodityImpl extends BaseMeans<Commodity> implements CommodityNorm {

    @Override
    public List<Commodity> find_ALLCommodity(Connection connection, String sql) throws SQLException{
        return this.selectRecordMany(connection, sql);
    }

    @Override
    public Commodity find_SingleCommodity(Connection connection, String sql, int fid) throws SQLException {
        return this.selectRecordSingle(connection,sql,fid);
    }

    @Override
    public boolean set_Commodity(Connection connection, String sql, Object... args) throws SQLException {
        int i = this.updateRecord(connection, sql, args);
        return i > 0;
    }

    @Override
    public boolean del_Commodity(Connection connection, String sql, int fid) throws SQLException {
        return this.deleteRecord(connection,sql, fid) > 0;
    }

    @Override
    public boolean add_Commodity(Connection connection, String sql, Object... args) throws SQLException {
        return this.addRecord(connection,sql,args) > 0;
    }

    @Override
    public List<Commodity> find_CommodityOfPage(Connection connection, String sql, int pageNo) throws SQLException {
        return this.selectRecordMany(connection,sql,pageNo);
    }

}
