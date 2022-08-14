package com.example.book.dao;

public enum OrderStatus {
    //已处理processed
    PROCESSED(-1),
    //未处理not processed
    NOT_PROCESSED(0);

    private final int ordinal;

    OrderStatus(int i) {
        this.ordinal = i;
    }

    public int getOrdinal() {
        return this.ordinal;
    }
}
