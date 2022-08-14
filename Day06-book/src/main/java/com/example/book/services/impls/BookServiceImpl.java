package com.example.book.services.impls;

import com.example.book.dao.BookStatus;
import com.example.book.dao.impls.BookDaoImpl;
import com.example.book.dao.pojo.Book;
import com.example.book.services.norm.BookServiceNorm;
import com.example.ssm.utils.ConnectionUtil;

import java.util.List;

public class BookServiceImpl implements BookServiceNorm {

    BookDaoImpl bookDao;

    @Override
    public List<Book> getBooks(BookStatus status) throws Exception {
        return bookDao.find_AllBookOState(ConnectionUtil.getConnection(),status);
    }

    @Override
    public Double getPriceOfBookSpecify(Book book) throws Exception {
        return bookDao.find_PriceOfBookSpecify(ConnectionUtil.getConnection(),book);
    }

    @Override
    public Book getBook(Integer bookID) throws Exception {
        return bookDao.find_Book(ConnectionUtil.getConnection(),bookID);
    }
}
