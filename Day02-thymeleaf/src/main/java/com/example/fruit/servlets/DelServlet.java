package com.example.fruit.servlets;

import com.example.fruit.dao.impls.CommodityImpl;
import com.example.ssm.view.ViewBaseServlet;
import com.utils.ConnectionUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "del" ,value = "/del.do")
public class DelServlet extends ViewBaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Connection connection = null;
        try {
            CommodityImpl commodity = new CommodityImpl();
            String sql = "DELETE FROM commodity WHERE fid = ?";
            connection = ConnectionUtils.getConnection();
            if (commodity.del_Commodity(connection,sql, Integer.parseInt(req.getParameter("fid")))) {
                resp.sendRedirect("index.do");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }finally{
            ConnectionUtils.close(connection);
        }
    }
}
