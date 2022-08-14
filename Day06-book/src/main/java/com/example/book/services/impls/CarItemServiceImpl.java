package com.example.book.services.impls;

import com.example.book.dao.impls.CartItemDaoImpl;
import com.example.book.dao.pojo.Book;
import com.example.book.dao.pojo.CartItem;
import com.example.book.dao.pojo.User;
import com.example.book.services.norm.CartItemServiceNorm;
import com.example.ssm.utils.ConnectionUtil;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class CarItemServiceImpl implements CartItemServiceNorm {
    CartItemDaoImpl cartItemDao;
    BookServiceImpl bookService;
    @Override
    public List<CartItem> getCartItems(User user) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        List<CartItem> allCartItem = cartItemDao.find_AllCartItem(connection, user);
        for (CartItem cartItem : allCartItem) {
            Book book = bookService.getBook(cartItem.getBook());
            cartItem.setBookDetail(book);
        }
        return allCartItem;
    }

    @Override
    public void addBookToCartItem(User user, Book book) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Map<Integer, CartItem> cartItemMap = user.getCart().getCartItemMap();
        if (cartItemMap.containsKey(book.getId())) {
            if (!cartItemDao.modify_CartItem(connection,book.getId(),1,user.getId())) {
                throw new RuntimeException("没有为改商品增加成功！");
            }
        }else{
            if(!cartItemDao.add_CartItem(connection,book.getId(),1,user.getId())){
                throw new RuntimeException("没有添加进购物车！");
            };
        }
    }

    @Override
    public void delCarItemFromUserCart(Integer userid) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        if (!cartItemDao.del_CartItem(connection , userid)) {
            throw new RuntimeException("无法删除");
        }
    }

    public void update(Integer book,Integer buyCount,Integer userID) throws Exception{
        Connection connection = ConnectionUtil.getConnection();
        cartItemDao.change_CartItem(connection,book,buyCount,userID);
    }
}
