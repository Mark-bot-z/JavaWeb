package com.example.book.services.norm;

import com.example.book.dao.pojo.Order;
import com.example.book.dao.pojo.User;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface OrderServiceNorm {

    String addOrder(User user) throws Exception;

    HashMap<Integer, Order> getOrders(User user) throws Exception;
}
