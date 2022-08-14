package com.example.ssm.core.filters;

import com.example.ssm.utils.ConnectionUtil;

import javax.servlet.*;
import java.sql.Connection;
import java.sql.SQLException;

public class B_AffairsManageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        Connection connection = null;
        try {
            connection = ConnectionUtil.getConnection();
            connection.setAutoCommit(false);

            chain.doFilter(request, response);
            connection.commit();
        }catch (Exception e){
            try {
                if (connection != null)
                connection.rollback();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }finally {
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void destroy() {
    }
}
