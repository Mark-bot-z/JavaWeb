package com.example.book.dao.impls;

import com.example.book.dao.norm.OrderItemDaoNorm;
import com.example.book.dao.pojo.OrderItem;
import com.example.ssm.base.BaseMeans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderItemDaoImpl extends BaseMeans<OrderItem> implements OrderItemDaoNorm {
    @Override
    public boolean addOrderItem(Connection connection , Integer book, Integer buyCount, Integer orderBean) throws SQLException {
        return super.addRecord(connection,
                "INSERT INTO t_order_item (book,buyCount,orderBean) VALUES (?,?,?)",
                book,buyCount,orderBean
        ) > 0;
    }

    @Override
    public List<OrderItem> find_AllOrderItem(Connection connection, Integer orderBean) throws SQLException{
        return super.selectRecordMany(connection,
                "SELECT * FROM t_order_item WHERE orderBean = ? ",
                orderBean
        );
    }

    public Integer getID(Connection connection) throws SQLException{
        return super.getValue(connection,"SELECT LAST_INSERT_ID()").intValue();
    }
}
