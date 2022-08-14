package com.example.book.dao.norm;

import com.example.book.dao.OrderStatus;
import com.example.book.dao.pojo.Order;
import com.example.book.dao.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDaoNorm {
    //根据用户购物车添加订单,返回一个生成的唯一订单号（orderNo）
    String addOrder(Connection connection , User user , OrderStatus orderStatus) throws SQLException;

    Integer find_OrderIDOFOrderNo(Connection connection) throws SQLException;

    Order find_Order(Connection connection , String UUID) throws  SQLException;

    Order find_Order(Connection connection , Integer orderID) throws  SQLException;

    List<Order> find_Orders(Connection connection , Integer orderUser) throws  SQLException;
}
