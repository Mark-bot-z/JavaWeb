package com.example.book.dao.pojo;

public class OrderItem {
    private Integer id;
    private Integer book;
    private Integer buyCount;
    private Book bookDetail;

    private Integer orderBean;//关联的订单id号

    public OrderItem(){
    }

    public OrderItem(Integer id, Integer book, Integer buyCount, Book bookDetail, Integer orderBean) {
        this.id = id;
        this.book = book;
        this.buyCount = buyCount;
        this.bookDetail = bookDetail;
        this.orderBean = orderBean;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Book getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(Book bookDetail) {
        this.bookDetail = bookDetail;
    }

    public Integer getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(Integer orderBean) {
        this.orderBean = orderBean;
    }
}
