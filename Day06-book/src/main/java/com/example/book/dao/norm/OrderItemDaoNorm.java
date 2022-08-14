package com.example.book.dao.norm;

import com.example.book.dao.pojo.OrderItem;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderItemDaoNorm {
    //根据订单id添加订单项
    boolean addOrderItem(Connection connection ,Integer book , Integer buyCount, Integer orderBean) throws SQLException;

    List<OrderItem> find_AllOrderItem(Connection connection, Integer orderBean) throws SQLException;
}
