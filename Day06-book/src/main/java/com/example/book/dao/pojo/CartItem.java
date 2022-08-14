package com.example.book.dao.pojo;

public class CartItem {
    private Integer id;
    private Integer book;
    private Integer buyCount;
    private Integer userBean;

    public Book getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(Book bookDetail) {
        this.bookDetail = bookDetail;
    }

    private Book bookDetail;


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

    public Integer getUserBean() {
        return userBean;
    }

    public void setUserBean(Integer userBean) {
        this.userBean = userBean;
    }

    public CartItem() {
    }
}
