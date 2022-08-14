package com.example.redirect;

import com.example.HTTPUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "text_redirect",value = "/opp")
public class Test extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HTTPUtils.setCharCode(req, resp);
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("重定向成功");
        }
    }
}
