package com.example.book.controllers;

import com.example.book.dao.pojo.User;
import com.example.book.services.impls.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class OrderController {
    OrderServiceImpl orderService;


    public String bill(HttpServletRequest request) throws Exception{
        //结账：
        /*
        * 1.订单表添加一条记录
        * 2.订单表项里添加相应的购物车项（转化），orderbean并关联订单表中的记录的id
        * 3.将购物车清除，购物表项中清除与这个用户的相关的购物项
        * 4.返回一个checkout.html页面
        * */
        Object user = request.getSession().getAttribute("user");
        String uuid = orderService.addOrder((User) user);
        //查询用户的订单集合
        request.getSession().setAttribute("uuid",uuid);
        request.getSession().setAttribute("user",user);
        return UserController.REDIRECT_PAGE_PATH + "pages/cart/checkout";

    }
}
