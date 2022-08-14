package com.example.book.controllers;

import com.example.book.dao.BookStatus;
import com.example.book.dao.pojo.Book;
import com.example.book.services.impls.BookServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BookController {
    BookServiceImpl bookService;

    public String getBooks(String status, HttpServletRequest request) throws Exception {
        List<Book> bookList;
        if (status.equals("on")) {
            bookList = bookService.getBooks(BookStatus.ON_SHELVES);
        } else {
            bookList = bookService.getBooks(BookStatus.OFF_SHELVES);
        }
        request.getSession().setAttribute("bookList", bookList);
        return UserController.REDIRECT_PAGE_PATH + "index";
    }
}
