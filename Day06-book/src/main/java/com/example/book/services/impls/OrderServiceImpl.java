package com.example.book.services.impls;

import com.example.book.dao.OrderStatus;
import com.example.book.dao.impls.OrderDaoImpl;
import com.example.book.dao.pojo.Order;
import com.example.book.dao.pojo.OrderItem;
import com.example.book.dao.pojo.User;
import com.example.book.services.norm.OrderServiceNorm;
import com.example.ssm.utils.ConnectionUtil;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;


public class OrderServiceImpl implements OrderServiceNorm {
    OrderDaoImpl orderDao;
    OrderItemServiceImpl orderItemService;

    @Override
    public String addOrder(User user) {
        Connection connection = ConnectionUtil.getConnection();
        String UUID;
        try {
            UUID = orderDao.addOrder(connection, user, OrderStatus.NOT_PROCESSED);

            Integer orderID = orderDao.find_OrderIDOFOrderNo(connection);
            Order order = orderDao.find_Order(connection, orderID);

            //1-1设置用户实体属性中刚刚加入的订单
            user.getOrderHashMap().put(orderID, order);

            orderItemService.addOrderItemFromUserOrder(user, orderID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return UUID;
    }

    @Override
    public HashMap<Integer, Order> getOrders(User user) throws Exception {
        HashMap<Integer, Order> ordersMap = new HashMap<>();
        Connection connection = ConnectionUtil.getConnection();
        List<Order> orders = orderDao.find_Orders(connection, user.getId());
        int count = 0;
        for (Order order : orders) {
            Integer orderBean = order.getId();
            List<OrderItem> orderItemList = orderItemService.getOrderItemList(orderBean);
            for (OrderItem orderItem : orderItemList) {
                count += orderItem.getBuyCount();
            }
            order.setBookBuyCount(count);
            count = 0;
            order.setOrderItemList(orderItemList);
            ordersMap.put(order.getId(), order);
        }
        return ordersMap;
    }
}
