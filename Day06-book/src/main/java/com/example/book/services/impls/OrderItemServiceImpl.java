package com.example.book.services.impls;

import com.example.book.dao.impls.OrderItemDaoImpl;
import com.example.book.dao.pojo.*;
import com.example.book.services.norm.OrderItemServiceNorm;
import com.example.ssm.utils.ConnectionUtil;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class OrderItemServiceImpl implements OrderItemServiceNorm {
    OrderItemDaoImpl orderItemDao;
    CartServiceImpl cartService;
    BookServiceImpl bookService;

    @Override
    public void addOrderItemFromUserOrder(User user, Integer orderBean) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Cart cart = user.getCart();
        Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
        Collection<CartItem> values = cartItemMap.values();

        List<OrderItem> orderItemList = user.getOrderHashMap().get(orderBean).getOrderItemList();
        Order order = user.getOrderHashMap().get(orderBean);
        int i = 0;
        for (CartItem value : values) {
            i = value.getBuyCount();
            orderItemDao.addOrderItem(connection,
                    value.getBook(),
                    i,
                    orderBean
            );
            //1-2顺便完成对用户实体属性中这个新增订单中的订单项的赋值
            orderItemList.add(new OrderItem(getID(connection),
                    value.getBook(),
                    i,
                    value.getBookDetail(),
                    orderBean)
            );
        }
        order.setBookBuyCount(i);

        //清空表t_cart_item用户相关项（Related Items）empty
        cartService.delCartItemToUserCart(user.getId());
        //清空User中属性Cart(重置)
        Cart cartTemp = new Cart();
        cartTemp.setTotalItem(0);
        cartTemp.setTotalMoney(0.0);
        user.setCart(cartTemp);
    }

    @Override
    public List<OrderItem> getOrderItemList(Integer orderBean) throws Exception{
        Connection connection = ConnectionUtil.getConnection();
        List<OrderItem> allOrderItem = orderItemDao.find_AllOrderItem(connection, orderBean);
        for (OrderItem orderItem : allOrderItem) {
            orderItem.setBookDetail(bookService.getBook(orderItem.getBook()));
        }
        return allOrderItem;
    }

    private Integer getID(Connection connection) throws Exception{
        return orderItemDao.getID(connection);
    }
}
