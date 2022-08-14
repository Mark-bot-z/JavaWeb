package com.example.fruit.controllers;

import com.example.fruit.dao.pojo.Commodity;
import com.example.fruit.services.impls.FruitServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class FruitController {
    private static FruitServiceImpl fruitService;

    private String index(String oper, String keyword, Integer pageNo, HttpServletRequest req) throws SQLException {
        String limitSql;
        String countSql;

        if ("search".equals(oper)) {
            req.getSession().setAttribute("keyword", keyword);
        } else {
            if (req.getSession().getAttribute("keyword") != null) {
                keyword = req.getSession().getAttribute("keyword").toString();
            }
        }

        limitSql = "SELECT * FROM commodity WHERE fname like '%" + keyword + "%'  LIMIT ? , 3 ";
        countSql = "SELECT COUNT(*) FROM commodity WHERE fname like '%" + keyword + "%'";

        List<Commodity> commodities = fruitService.getFruitOfPage(
                limitSql,
                (pageNo - 1) * 3);

        req.getSession().setAttribute("commodityList", commodities);
        req.getSession().setAttribute("pageNo", pageNo);//设置当前页码
        req.getSession().setAttribute("totalPages",
                (fruitService.getFruitTotalCount(countSql) + 2) / 3);//设置总页码
        return "html:index";
    }

    private String add(String name, Integer price, Integer count, String remark) throws SQLException {
        String sql = "INSERT INTO commodity(fname , price , fcount , remark) VALUES (?,?,?,?)";
        if (fruitService.addFruit(sql, name, price, count, remark)) {
            return "redirect:fruit.do?operator=index";
        }
        return null;
    }

    private String del(Integer fid) throws SQLException {
        String sql = "DELETE FROM commodity WHERE fid = ?";
        if (fruitService.deleteFruit(sql, fid)) {
            return "redirect:fruit.do?operator=index";
        }
        return null;
    }

    private String edit(HttpServletRequest req, Integer fid) throws SQLException {
        String sql = "SELECT * FROM commodity WHERE fid = ?";
        req.setAttribute("fruit", fruitService.getFruit(sql, fid));
        return "html:edit";
    }

    private String update(String name, Integer price, Integer count, String remark, Integer fid) throws SQLException {
        String sql = "UPDATE commodity SET fname = ? , price = ? , fcount = ? , remark = ? WHERE fid = ?";
        if (fruitService.updateFruit(sql, name, price, count, remark, fid)) {
            return "redirect:fruit.do?operator=index";
        }
        return null;
    }
}
