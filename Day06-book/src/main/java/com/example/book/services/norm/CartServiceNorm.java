package com.example.book.services.norm;

import com.example.book.dao.pojo.Book;
import com.example.book.dao.pojo.Cart;
import com.example.book.dao.pojo.User;

public interface CartServiceNorm {
    //根据用户信息获取购物车
    Cart getCart(User user) throws Exception;

    //获取指定购物车的总价
    Double getTotalMoneyOfCart(Cart cart) throws Exception;

    void addBookToCart(User user, Book book) throws Exception;

    void delCartItemToUserCart(Integer userid) throws Exception;
}
