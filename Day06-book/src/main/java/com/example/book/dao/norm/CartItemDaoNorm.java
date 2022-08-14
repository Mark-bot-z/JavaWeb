package com.example.book.dao.norm;

import com.example.book.dao.pojo.CartItem;
import com.example.book.dao.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CartItemDaoNorm {

    //查询与用户信息相关的所有购物车项
    List<CartItem> find_AllCartItem(Connection connection , User user) throws SQLException;

    //根据用户信息添加购物车项
    boolean add_CartItem(Connection connection,Integer book , Integer buyCount,Integer userID) throws SQLException;

    //修改购物车项(有可能是同一本书的再次添加)
    boolean modify_CartItem(Connection connection ,Integer book , Integer buyCount , Integer userID)throws SQLException;


    boolean del_CartItem(Connection connection , Integer userid) throws SQLException;

}
