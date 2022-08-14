package com.example.servlet;

import com.example.HTTPUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        HTTPUtils.setCharCode(req, resp);
        req.getSession().setAttribute("username", req.getParameter("username"));
    }
}
