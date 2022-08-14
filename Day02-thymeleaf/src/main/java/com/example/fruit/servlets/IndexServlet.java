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
import java.util.List;

@WebServlet(name = "index" , value = "/index.do")
public class IndexServlet extends ViewBaseServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HTTPUtils.setCharCode(req, resp);
        CommodityImpl commodity = new CommodityImpl();

        String limitSql;
        String countSql;

        String keyword = "";

        if ("search".equals(req.getParameter("oper"))){
            keyword = req.getParameter("keyword");
            req.getSession().setAttribute("keyword",req.getParameter("keyword"));
        }else{
            if (req.getSession().getAttribute("keyword") != null) {
                keyword = req.getSession().getAttribute("keyword").toString();
            }
        }

        limitSql = "SELECT * FROM commodity WHERE fname like '%"+ keyword +"%'  LIMIT ? , 3 ";
        countSql = "SELECT COUNT(*) FROM commodity WHERE fname like '%"+ keyword +"%'";

        try (Connection connection = ConnectionUtils.getConnection()) {
            int pageNo = 1;

            if (req.getParameter("pageNo") != null) {
                pageNo = Integer.parseInt(req.getParameter("pageNo"));
            }

            List<Commodity> commodities = commodity.find_CommodityOfPage(connection,
                    limitSql,
                    (pageNo-1)*3);

            req.getSession().setAttribute("commodityList", commodities);
            req.getSession().setAttribute("pageNo",pageNo);//设置当前页码

            Long value = commodity.getValue(connection, countSql);
            req.getSession().setAttribute("totalPages", (value+2)/3);//设置总页码

            super.processTemplate("index", req  ,  resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
