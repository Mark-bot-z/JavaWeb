package com.example.fruit.servlets;

import com.example.fruit.dao.impls.CommodityImpl;
import com.example.ssm.view.ViewBaseServlet;
import com.utils.ConnectionUtils;
import com.utils.HTTPUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "add", value = "/add.do")
public class AddServlet extends ViewBaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HTTPUtils.setCharCode(req, resp);
        Connection connection = null;
        String sql = "INSERT INTO commodity(fname , price , fcount , remark) VALUES (?,?,?,?)";
        try {
            CommodityImpl commodity = new CommodityImpl();
            connection = ConnectionUtils.getConnection();
            if (commodity.add_Commodity(connection,
                    sql,
                    req.getParameter("name"),
                    req.getParameter("price"),
                    req.getParameter("count"),
                    req.getParameter("remark"))) {

                resp.sendRedirect("index.do");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            ConnectionUtils.close(connection);
        }
    }
}
