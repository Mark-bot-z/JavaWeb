package com.example.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


public class AuthenticateUserFilter implements Filter {
    List<String> whitelist = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) {
        Enumeration<String> parameterNames = filterConfig.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            whitelist.add(filterConfig.getInitParameter(s));
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        System.out.println("req.getQueryString() = " + req.getQueryString());

        int i = req.getQueryString().indexOf("=");
        String subURL = req.getQueryString().substring(i + 1);

        if (whitelist.contains(subURL)) {
            chain.doFilter(request, response);
        } else {
            if (req.getParameter("operator").equals("login")) {
                String s = whitelist.get(1);
                s= MessageFormat.format(s,req.getParameter("uname"),req.getParameter("pwd"));
                if (s.equals(subURL)) {
                    chain.doFilter(request, response);
                }
            }else if (req.getParameter("operator").equals("register")){
                chain.doFilter(request, response);
            }else{
                Object user = req.getSession().getAttribute("user");
                if (user != null) {
                    chain.doFilter(request, response);
                } else {
                    resp.sendRedirect("page.do?operator=getPages&pageName=pages/user/login");
                }
            }
        }
    }
}
