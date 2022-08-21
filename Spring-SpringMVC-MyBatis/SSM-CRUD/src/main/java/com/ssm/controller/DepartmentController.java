package com.ssm.controller;


import com.ssm.daos.pojo.Department;
import com.ssm.service.norm.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/findDepartments")
    @ResponseBody
    public List<Department> findDepartments(){
        return departmentService.findDepartments();
    }

}
