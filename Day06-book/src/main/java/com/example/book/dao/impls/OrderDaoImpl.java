package com.example.book.dao.impls;

import com.example.book.dao.OrderStatus;
import com.example.book.dao.norm.OrderDaoNorm;
import com.example.book.dao.pojo.Cart;
import com.example.book.dao.pojo.Order;
import com.example.book.dao.pojo.User;
import com.example.ssm.base.BaseMeans;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderDaoImpl extends BaseMeans<Order> implements OrderDaoNorm {


   /*
   *private Integer id;
    private String orderNo;//唯一订单号
    private Date orderDate;
    private Integer orderUser;//订单关联的用户
    private Double orderMoney;
    private Integer orderStatus;//订单状态  0--->为未处理
   * */

    @Override
    public String addOrder(Connection connection, User user, OrderStatus orderStatus) throws SQLException {
        Cart cart = user.getCart();
        String s = UUID.randomUUID().toString();
        Date date = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        if (super.addRecord(connection,
                "INSERT INTO t_order(orderNo,orderDate,orderUser,orderMoney,orderStatus) VALUES (?,?,?,?,?)",
                s,
                simple.format(date),
                user.getId(),
                cart.getTotalMoney(),
                orderStatus.getOrdinal()) > 0) {
            return s;
        }
        throw new RuntimeException("无法添加订单!!!");
    }

    @Override
    public Integer find_OrderIDOFOrderNo(Connection connection) throws SQLException {
        //返回刚刚插入的主键id
        return super.getValue(connection,
                "SELECT LAST_INSERT_ID();"
        ).intValue();
    }

    @Override
    public Order find_Order(Connection connection, String UUID) throws SQLException {
        return super.selectRecordSingle(connection,"SELECT * FROM t_order WHERE orderNo = ?",UUID);
    }

    @Override
    public Order find_Order(Connection connection, Integer orderID) throws SQLException {
        return super.selectRecordSingle(connection,"SELECT * FROM t_order WHERE id = ?",orderID);
    }

    @Override
    public List<Order> find_Orders(Connection connection, Integer orderUser) throws SQLException {
        return super.selectRecordMany(connection,"SELECT * FROM t_order WHERE orderUser = ?",orderUser);
    }
}
