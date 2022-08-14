package com.example.fruit.servlets;


import com.example.fruit.dao.impls.CommodityImpl;
import com.example.ssm.view.ViewBaseServlet;
import com.utils.ConnectionUtils;
import com.utils.HTTPUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "update", value = "/update.do")
public class UpdateServlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HTTPUtils.setCharCode(req, resp);
        Connection connection = null;
        try {
            String sql = "UPDATE commodity SET fname = ? , price = ? , fcount = ? , remark = ? WHERE fid = ?";
            connection = ConnectionUtils.getConnection();
            if (new CommodityImpl().set_Commodity(connection,
                    sql,
                    req.getParameter("name"),
                    req.getParameter("price"),
                    req.getParameter("count"),
                    req.getParameter("remark"), req.getParameter("fid"))) {
                resp.sendRedirect("index.do");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            ConnectionUtils.close(connection);
        }
    }
}
