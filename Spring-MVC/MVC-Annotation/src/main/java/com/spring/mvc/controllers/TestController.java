package com.spring.mvc.controllers;

import com.spring.mvc.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/annotationTestController")
public class TestController {

    @Autowired
    JdbcTemplate template;

    @RequestMapping(value = "/home")
    public String home() {
        List<Employee> query = template.query("SELECT * FROM empdb.emp",
                new BeanPropertyRowMapper<>(Employee.class)
        );
        query.forEach(employee -> System.out.println(employee.toString()));
        return "home";
    }


}
