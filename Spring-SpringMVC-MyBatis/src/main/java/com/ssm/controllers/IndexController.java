package com.ssm.controllers;

import com.github.pagehelper.PageInfo;
import com.ssm.daos.pojo.Employee;
import com.ssm.services.EmployeeServiceNorm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/Index")
public class IndexController {

    @Autowired
    private EmployeeServiceNorm employeeService;

    @RequestMapping(value = "/home")
    public String home(){
        employeeService.say();
        return "/home";
    }


    @RequestMapping(value = "/pages/{pageNumbers}")
    public String pages(@PathVariable("pageNumbers") Integer pageNumbers, Model model){
        PageInfo<Employee> page = employeeService.findEmployeeByPageNums(pageNumbers);
        model.addAttribute("page",page);
        return "employee_list";
    }

}
