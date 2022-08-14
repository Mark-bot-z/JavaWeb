package com.example.book.dao.pojo;


import java.util.ArrayList;
import java.time.*;
import java.util.List;

public class Order {
    private Integer id;
    private String orderNo;//唯一订单号
    private LocalDateTime orderDate;
    private Integer orderUser;//订单关联的用户
    private Double orderMoney;
    private Integer orderStatus;//订单状态  0--->为未处理
    private int bookBuyCount;

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    private List<OrderItem> orderItemList = new ArrayList<>();


    public Order(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

//    public String getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(String orderDate) {
//        this.orderDate = orderDate;
//    }

//    public Date getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(Date orderDate) {
//        this.orderDate = orderDate;
//    }

    public Integer getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(Integer orderUser) {
        this.orderUser = orderUser;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setBookBuyCount(int bookBuyCount) {
        this.bookBuyCount = bookBuyCount;
    }

    public int getBookBuyCount() {
        return bookBuyCount;
    }
}
