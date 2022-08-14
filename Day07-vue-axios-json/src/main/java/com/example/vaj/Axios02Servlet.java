package com.example.vaj;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(value = "/axios02.do")
public class Axios02Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        BufferedReader reader = req.getReader();
        StringBuilder result = new StringBuilder();
        char[] chars = new char[20];
        int le;
        while((le = reader.read(chars,0,10)) != -1){
            for (int i = 0; i < le; i++) {
                result.append(chars[i]);
            }
        }
        Gson gson = new Gson();
        User user = gson.fromJson(result.toString(), User.class);
        user.pwd="sfdje";
        user.uname="234";

        String s = gson.toJson(user);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json,character=utf-8");

        resp.getWriter().write(s);
    }

    public static class User{
        String uname;
        String pwd;

        @Override
        public String toString() {
            return "User{" +
                   "uname='" + uname + '\'' +
                   ", pwd='" + pwd + '\'' +
                   '}';
        }
    }
}
