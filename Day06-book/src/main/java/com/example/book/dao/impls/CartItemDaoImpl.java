package com.example.book.dao.impls;

import com.example.book.dao.norm.CartItemDaoNorm;
import com.example.book.dao.pojo.CartItem;
import com.example.book.dao.pojo.User;
import com.example.ssm.base.BaseMeans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CartItemDaoImpl extends BaseMeans<CartItem> implements CartItemDaoNorm {

    @Override
    public List<CartItem> find_AllCartItem(Connection connection ,User user) throws SQLException {
        List<CartItem> cartItemList;
        return (cartItemList =  super.selectRecordMany(
                connection,
                "SELECT * FROM t_cart_item WHERE userBean = ?",
                user.getId()
        )) != null ? cartItemList : null;
    }

    @Override
    public boolean add_CartItem(Connection connection,Integer book , Integer buyCount ,Integer userID) throws SQLException {
        return super.addRecord(connection,
                "INSERT INTO t_cart_item(book,buyCount,userBean) " +
                "VALUES (?,?,?)",
                book,buyCount,userID
        ) > 0;
    }

    @Override
    public boolean modify_CartItem(Connection connection,Integer book, Integer buyCount,Integer userID) throws SQLException {
        return super.updateRecord(connection,
                "UPDATE t_cart_item SET buyCount = buyCount + ? WHERE book = ? AND userBean = ?",
                buyCount,
                book,
                userID
        ) > 0;
    }

    public boolean change_CartItem(Connection connection,Integer book, Integer buyCount,Integer userID) throws SQLException {
        return super.updateRecord(connection,
                "UPDATE t_cart_item SET buyCount = ? WHERE book = ? AND userBean = ?",
                buyCount,
                book,
                userID
        ) > 0;
    }

    @Override
    public boolean del_CartItem(Connection connection, Integer userid) throws SQLException {
        return super.deleteRecord(connection,"DELETE FROM t_cart_item WHERE userBean = ?", userid) > 0;
    }
}
