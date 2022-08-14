package com.example.book.controllers;

import com.example.book.dao.pojo.Cart;
import com.example.book.dao.pojo.Order;
import com.example.book.dao.pojo.User;
import com.example.book.services.impls.CartServiceImpl;
import com.example.book.services.impls.OrderServiceImpl;
import com.example.book.services.impls.UserServiceImpl;
import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class UserController {

    public static final String REDIRECT_PAGE_PATH = "redirect:page.do?operator=getPages&pageName=";
    UserServiceImpl userService;
    CartServiceImpl cartService;
    OrderServiceImpl orderService;

    public String login(String uname, String pwd, HttpServletRequest request) throws Exception {
        User user = new User(uname, pwd);
        if ((user = userService.getUser(user)) != null) {
            //获取并设置这个用户的购物车
            Cart cart = cartService.getCart(user);
            user.setCart(cart);
            //获取并设置这个用户的订单
            HashMap<Integer, Order> orders = orderService.getOrders(user);
            user.setOrderHashMap(orders);
            request.getSession().setAttribute("user", user);
            return REDIRECT_PAGE_PATH + "pages/user/login_success";
        }
        return "html:error";
    }

    public String logout(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return REDIRECT_PAGE_PATH + "pages/user/login";
    }

    public String register(HttpServletRequest request ,String verification_code) {
        //在请求com.google.code.kaptcha.servlet.KaptchaServlet的图片时，就会一并把答案设置进session中
        Object answer = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (verification_code.equals(answer)){
            //注册省略
            return REDIRECT_PAGE_PATH + "pages/user/login";
        }
        //验证码错误
        return "html:error";
    }
}
