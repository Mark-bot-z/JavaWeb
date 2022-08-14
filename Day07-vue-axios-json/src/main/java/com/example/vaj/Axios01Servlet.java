package com.example.vaj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/axios01.do")
public class Axios01Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("req.getParameter(\"uname\") = " + req.getParameter("uname"));
        System.out.println("req.getParameter(\"pwd\") = " + req.getParameter("pwd"));
    }
}
