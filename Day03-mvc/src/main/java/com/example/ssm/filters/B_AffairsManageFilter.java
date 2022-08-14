package com.example.ssm.filters;

import com.utils.ConnectionUtils;

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
            connection = ConnectionUtils.getConnection();
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
            ConnectionUtils.close(connection);
        }
    }

    @Override
    public void destroy() {
    }
}
