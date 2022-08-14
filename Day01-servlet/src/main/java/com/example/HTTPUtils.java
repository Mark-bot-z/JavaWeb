package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public class HTTPUtils {
    public static void setCharCode(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=utf-8");
    }

    /**
     * 设置当前页面不被缓存
     * @param resp 响应头
     */
    public static void setNoCache(HttpServletResponse resp){
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        resp.setDateHeader("Expires", 0); // Proxies.
    }
}
