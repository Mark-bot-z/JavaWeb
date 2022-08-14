package com.example.fruit.services.impls;

import com.example.fruit.dao.impls.CommodityImpl;
import com.example.fruit.dao.pojo.Commodity;
import com.example.fruit.services.FruitService;
import com.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Mark-Z
 * @version 0.0.1
 * @date 2022/7/7
 * @implNote Fruit service层的实现类
 */
public class FruitServiceImpl implements FruitService {

    private static CommodityImpl commodityNorm;

    @Override
    public List<Commodity> getAllFruit(String sql) {
        throw new RuntimeException("FruitServiceImpl - getAllFruit() 方法暂未实现");
    }

    @Override
    public Commodity getFruit(String sql, int fid) throws SQLException {
        Commodity commodity;
        Connection connection = ConnectionUtils.getConnection();
        commodity = commodityNorm.find_SingleCommodity(connection, sql, fid);
        return commodity;
    }

    @Override
    public boolean updateFruit(String sql, Object... args) throws SQLException {
        boolean b;
        Connection connection = ConnectionUtils.getConnection();
        b = commodityNorm.set_Commodity(connection, sql, args);
        return b;
    }

    @Override
    public boolean deleteFruit(String sql, int fid) throws SQLException {
        boolean is;
        Connection connection = ConnectionUtils.getConnection();
        is = commodityNorm.del_Commodity(connection, sql, fid);
        return is;
    }

    @Override
    public boolean addFruit(String sql, Object... args) throws SQLException {
        boolean is;
        Connection connection = ConnectionUtils.getConnection();
        is = commodityNorm.add_Commodity(connection, sql, args);
        return is;
    }

    @Override
    public List<Commodity> getFruitOfPage(String sql, int pageNo) throws SQLException {
        List<Commodity> allCommodity;
        Connection connection = ConnectionUtils.getConnection();
        allCommodity = commodityNorm.find_CommodityOfPage(connection, sql, pageNo);
        return allCommodity;
    }

    @Override
    public Long getFruitTotalCount(String sql) throws SQLException {
        Long value;
        Connection connection = ConnectionUtils.getConnection();
        value = commodityNorm.getValue(connection, sql);
        return value;
    }
}
