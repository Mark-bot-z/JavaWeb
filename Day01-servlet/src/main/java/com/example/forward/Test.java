package com.example.forward;

import com.example.HTTPUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "test_forward",value = "/kar")
public class Test extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HTTPUtils.setCharCode(req, resp);
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("我是另外一个servlet");
        }
    }
}
