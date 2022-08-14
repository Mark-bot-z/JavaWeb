package com.example.book.services.norm;

import com.example.book.dao.pojo.Book;
import com.example.book.dao.pojo.Cart;
import com.example.book.dao.pojo.CartItem;
import com.example.book.dao.pojo.User;

import java.util.List;

public interface CartItemServiceNorm {

    List<CartItem> getCartItems(User user) throws Exception;

    void addBookToCartItem(User user, Book book) throws Exception;

    void delCarItemFromUserCart(Integer userid) throws Exception;
}
