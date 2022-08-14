package com.example.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

    public HelloServlet(){
        System.out.println("实例化唯一  ");
        System.out.print("-- HelloServlet.HelloServlet");
    }

    //初始化
    /*接收第一次请求时*/
    @Override
    public void init() {
        System.out.println("初始化。。。");
    }

    /*对于每一次请求，都会调用这个方法*/
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service 服务中");
    }

    //销毁
    @Override
    public void destroy() {
    }
}