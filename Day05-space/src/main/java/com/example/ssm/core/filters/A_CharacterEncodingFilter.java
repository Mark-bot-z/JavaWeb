package com.example.ssm.core.filters;

import javax.servlet.*;
import java.io.IOException;

public class A_CharacterEncodingFilter implements Filter {
    private String characterEncoding;
    private String contentType;

    @Override
    public void init(FilterConfig filterConfig) {
        this.characterEncoding = filterConfig.getInitParameter("UTF-8");
        this.contentType = filterConfig.getInitParameter("ContentType");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(characterEncoding);
        response.setCharacterEncoding(characterEncoding);
        response.setContentType(contentType);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter.destroy");
    }
}
