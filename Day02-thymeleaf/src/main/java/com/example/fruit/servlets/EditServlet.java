package com.example.fruit.servlets;

import com.example.fruit.dao.impls.CommodityImpl;
import com.example.fruit.pojo.Commodity;
import com.example.ssm.view.ViewBaseServlet;
import com.utils.ConnectionUtils;
import com.utils.HTTPUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "edit", value = "/edit.do")
public class EditServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HTTPUtils.setCharCode(req, resp);
        Connection connection = null;
        int fid = Integer.parseInt(req.getParameter("fid"));
        try {
            String sql = "SELECT * FROM commodity WHERE fid = ?";
            connection = ConnectionUtils.getConnection();
            Commodity commodity = new CommodityImpl().find_SingleCommodity(connection, sql, fid);
            req.setAttribute("fruit", commodity);

            super.processTemplate("edit", req, resp);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (connection != null) {
                ConnectionUtils.close(connection);
            }
        }
    }
}
