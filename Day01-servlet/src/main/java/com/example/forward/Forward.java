package com.example.forward;

import com.example.HTTPUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//服务器内部转发
public class Forward extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HTTPUtils.setCharCode(req, resp);
        req.getRequestDispatcher("kar").forward(req,resp);
    }
}
