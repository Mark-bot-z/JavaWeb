package com.example.book.dao;

//上架  下架
public enum BookStatus {
    ON_SHELVES(0) , OFF_SHELVES(-1);

    private final int ordinal;

    BookStatus(int i) {
        this.ordinal = i;
    }

    public int getOrdinal() {
        return this.ordinal;
    }
}
