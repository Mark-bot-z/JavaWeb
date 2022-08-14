package com.example.book.services.impls;

import com.example.book.dao.pojo.Book;
import com.example.book.dao.pojo.Cart;
import com.example.book.dao.pojo.CartItem;
import com.example.book.dao.pojo.User;
import com.example.book.services.norm.CartServiceNorm;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CartServiceImpl implements CartServiceNorm {

    CarItemServiceImpl carItemService;
    BookServiceImpl bookService;

    @Override
    public Cart getCart(User user) throws Exception {
        //往购物车中添加购物车项
        //1。如果没有购物车也没有购物车项，就直接给个new Cart
        //2. 如果有购物车，也有于这个用户相关的购物车项则加入进这个购物车
        Cart cartTemp = user.getCart();
        if (cartTemp == null) {
            cartTemp = new Cart();
        }
        relatedItem(user, cartTemp);
        return cartTemp;
    }

    private void relatedItem(User user, Cart cartTemp) throws Exception {
        //查找于这个用户所相关的所有item
        List<CartItem> cartItems = carItemService.getCartItems(user);
        if (cartItems != null) {
            Map<Integer, CartItem> cartItemMap = cartTemp.getCartItemMap();
            for (CartItem cartItem : cartItems) {
                cartItemMap.put(cartItem.getBook(), cartItem);
            }
            //计算
            calculate(cartTemp, cartItemMap);
        }
    }

    private void calculate(Cart cartTemp, Map<Integer, CartItem> cartItemMap) throws Exception {
        cartTemp.setTotalItem(cartItemMap.size());
        cartTemp.setTotalMoney(this.getTotalMoneyOfCart(cartTemp));
    }

    @Override
    public Double getTotalMoneyOfCart(Cart cart) throws Exception {
        Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
        Collection<CartItem> values = cartItemMap.values();
        double totalMoney = 0.0;
        for (CartItem value : values)
            totalMoney += (bookService.getPriceOfBookSpecify(new Book(value.getBook()))) * value.getBuyCount();
        return totalMoney;
    }

    @Override
    public void addBookToCart(User user, Book book) throws Exception {
        carItemService.addBookToCartItem(user, book);
        this.relatedItem(user, user.getCart());
    }

    @Override
    public void delCartItemToUserCart(Integer userid) throws Exception {
        carItemService.delCarItemFromUserCart(userid);

    }

    public void update(CartItem cartItem, Integer buyCount, User user) throws Exception {
        carItemService.update(cartItem.getBook(),buyCount,user.getId());
        Cart cart = getCart(user);
        user.setCart(cart);
    }
}
