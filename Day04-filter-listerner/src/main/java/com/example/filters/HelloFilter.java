package com.example.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/**
 * @author Mark-Z
 * @version 0.0.1
 * @date 2022/7/7
 * @implNote 这是一种过滤servlet
 */
@WebFilter(value = "*.do")
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("已拦截java.do");
        chain.doFilter(request, response);//放行
        System.out.println("放行响应");
    }

    @Override
    public void destroy() {

    }
}
