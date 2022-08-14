package com.example.book.services.norm;

import com.example.book.dao.BookStatus;
import com.example.book.dao.pojo.Book;

import java.util.List;

public interface BookServiceNorm {
    //获取指定状态的所有书
    List<Book> getBooks(BookStatus status) throws  Exception;

    //获取指定书籍的价格
    Double getPriceOfBookSpecify(Book book) throws  Exception;

    //获取指定书籍
    Book getBook (Integer bookID) throws Exception;
}
