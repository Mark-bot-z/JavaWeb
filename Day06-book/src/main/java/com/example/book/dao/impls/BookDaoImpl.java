package com.example.book.dao.impls;

import com.example.book.dao.BookStatus;
import com.example.book.dao.norm.BookDaoNorm;
import com.example.book.dao.pojo.Book;
import com.example.ssm.base.BaseMeans;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl extends BaseMeans<Book> implements BookDaoNorm {
    @Override
    public List<Book> find_AllBookOState(Connection connection, BookStatus status) throws SQLException {
        List<Book> bookList;
        return (bookList = super.selectRecordMany(connection,
                "SELECT * FROM t_book WHERE bookStatus = ?",
                status.getOrdinal()
        )) != null ? bookList : null;
    }

    @Override
    public Double find_PriceOfBookSpecify(Connection connection, Book book) throws SQLException {
        final BookStatus status = BookStatus.ON_SHELVES;
        book = super.selectRecordSingle(connection,
                "SELECT price FROM t_book WHERE bookStatus = ? AND id = ?",
                status.getOrdinal(),
                book.getId()
        );
        return book.getPrice();
    }

    @Override
    public Book find_Book(Connection connection, Integer bookID) throws SQLException {
        return super.selectRecordSingle(connection,
                "SELECT * FROM t_book WHERE id = ?",
                bookID
        );
    }
}
