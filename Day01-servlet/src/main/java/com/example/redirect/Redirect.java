package com.example.redirect;

import com.example.HTTPUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//重定向
public class Redirect extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HTTPUtils.setCharCode(req, resp);
        resp.sendRedirect("opp");
    }
}
