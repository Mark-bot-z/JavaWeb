package com.example.servlet;

import com.example.HTTPUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HTTPUtils.setCharCode(req, resp);
        Object username = req.getSession().getAttribute("username");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write((String) username);
        }
    }
}
