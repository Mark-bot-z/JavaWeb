package com.example.book.dao.pojo;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Integer , CartItem> cartItemMap = new HashMap<>();//保存这个购物车所有的项
    private Integer totalItem = 0;//总计
    private Double totalMoney = 0.0;//总金额

    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
