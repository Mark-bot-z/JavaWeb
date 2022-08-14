package com.example.book.dao.norm;

import com.example.book.dao.BookStatus;
import com.example.book.dao.pojo.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BookDaoNorm {
    //根据状态
    List<Book> find_AllBookOState(Connection connection , BookStatus status) throws SQLException;

    Double find_PriceOfBookSpecify(Connection connection , Book book) throws SQLException;

    Book find_Book(Connection connection , Integer bookID) throws SQLException;
}
