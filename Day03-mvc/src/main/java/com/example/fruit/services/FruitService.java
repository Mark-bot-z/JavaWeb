package com.example.fruit.services;

import com.example.fruit.dao.pojo.Commodity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Mark-Z
 * @version 0.0.1
 * @date 2022/7/7
 * @implNote 对于水果业务层的接口方法实现规范，相比于dao层的方法粗粒度高
 */
public interface FruitService {
    //查询所有所有水果
    List<Commodity> getAllFruit(String sql) throws SQLException;

    //查询单个水果
    Commodity getFruit( String sql, int fid) throws SQLException;

    //更新一个水果的信息
    boolean updateFruit(String sql, Object... args) throws SQLException;

    //删除一个水果
    boolean deleteFruit(String sql, int fid) throws SQLException;

    //添加一个水果
    boolean addFruit(String sql, Object... args) throws SQLException;

    //分页查询水果列表
    List<Commodity> getFruitOfPage(String sql , int pageNo) throws SQLException;

    //获取水果的个数
    Long getFruitTotalCount(String sql) throws SQLException;
}
