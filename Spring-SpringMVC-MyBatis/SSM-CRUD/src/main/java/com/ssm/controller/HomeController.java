package com.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.ssm.daos.pojo.Employee;
import com.ssm.service.norm.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/goToTheHomePage" ,  method = RequestMethod.GET)
    public String goToTheHomePage(){
        return "home";
    }

    @RequestMapping(value = "/findEmployeesByPageNums/{pageNums}" ,  method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Employee> findEmployeesByPageNums(@PathVariable("pageNums") Integer pageNums, HttpServletRequest request){
        return employeeService.findEmployeesByPageNums(pageNums);
    }
}
