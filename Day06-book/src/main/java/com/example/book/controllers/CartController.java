package com.example.book.controllers;

import com.example.book.dao.pojo.Book;
import com.example.book.dao.pojo.CartItem;
import com.example.book.dao.pojo.User;
import com.example.book.services.impls.CartServiceImpl;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

public class CartController {

    CartServiceImpl cartService;

    public String addBookToCart(Integer bookID, HttpServletRequest request) throws Exception{
        User user = (User)request.getSession().getAttribute("user");
        cartService.addBookToCart(user, new Book(bookID));
        return UserController.REDIRECT_PAGE_PATH + "index";
    }


    public String getCartDetail() throws Exception{
        return UserController.REDIRECT_PAGE_PATH + "pages/cart/cart";
    }


    public String edit(Integer CartItemid , Integer buyCount , HttpServletRequest request) throws Exception{
        User user = (User)request.getSession().getAttribute("user");
        Collection<CartItem> values = user.getCart().getCartItemMap().values();

        CartItem cartItem = null;
        for (CartItem value : values) {
            if (value.getId().equals(CartItemid)) {
                cartItem = value;
                break;
            }
        }

        assert cartItem != null;
        cartService.update(cartItem ,buyCount , user);
        request.getSession().setAttribute("user",user);
        return getCartDetail();
    }

    public String getCartInfo(HttpServletRequest request) throws Exception{
        User user = (User) request.getSession().getAttribute("user");
        Gson gson = new Gson();
        user.setCart(cartService.getCart(user));
        request.getSession().setAttribute("user",user);
//        response.setContentType("application/json,charset=utf-8");
        return "json:" + gson.toJson(user.getCart());
    }
}
