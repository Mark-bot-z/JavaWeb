package com.example.book.services.norm;

import com.example.book.dao.pojo.OrderItem;
import com.example.book.dao.pojo.User;

import java.util.List;

public interface OrderItemServiceNorm {
    void addOrderItemFromUserOrder(User user,Integer orderBean) throws Exception;

    List<OrderItem> getOrderItemList(Integer orderBean) throws Exception;
}
