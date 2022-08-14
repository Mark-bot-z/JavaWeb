package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WorldServlet extends HttpServlet {
    public WorldServlet() {
        System.out.print("实例化中  ");
        System.out.println("--  WorldServlet.WorldServlet");
    }

    @Override
    public void init() {
        System.out.println("WorldServlet.init 初始化中");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WorldServlet.service 服务中");
    }
}
