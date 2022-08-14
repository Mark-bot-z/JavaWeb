package com.spring.mvc.controllers;


import com.spring.mvc.daos.pojo.Employee;
import com.spring.mvc.services.norm.EmployeeServiceNorm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    @Qualifier(value = "EmployeeServiceImpl")
    private EmployeeServiceNorm employeeServiceNorm;

    //    访问首页√	/	GET and post
    @RequestMapping(value = "/home")
    public String home() {
        return "restful/employee_home";
    }

    //查询全部数据√	/employee	GET
    @RequestMapping(value = "/getAllEmp", method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        List<Employee> allEmployees = employeeServiceNorm.getAllEmployees();
        model.addAttribute("allEmployees", allEmployees);
        return "restful/empList";
    }

    //    删除√	/employee/2	DELETE
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delEmpByID(@PathVariable(value = "id") Integer id) {
        employeeServiceNorm.delEmpByID(id);
        return "forward:/Employee/getAllEmp";
    }

    //    跳转到添加数据页面√	/toAdd	GET
    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "restful/employee_add";
    }

    /*
     * restful风格
     * */
    //        执行保存√	/employee	POST
    @RequestMapping(value = "/{lastName}/{email}/{gender}",method = RequestMethod.POST)
    public void addSave(@PathVariable("lastName") String lastName,
                        @PathVariable("email") String email,
                        @PathVariable("gender")Integer gender, HttpServletResponse response){
        Employee employee = new Employee(lastName, email, gender);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            if (employeeServiceNorm.save(employee)) {
                writer.write("添加成功!");
            }
        } catch (Exception e) {
            assert false;
            writer.write("添加失败!");
        }
    }

    /*
     * 传统风格
     * */
    //    执行保存√	/employee	POST
//    @RequestMapping(value = "/addSave", method = RequestMethod.POST)
//    public void addSave(Employee employee, HttpServletResponse response) throws Exception {
//        PrintWriter writer = response.getWriter();
//        if (employeeServiceNorm.save(employee)) {
//            writer.write("添加成功!");
//        } else {
//            writer.write("添加失败!");
//        }
//    }


    // 跳转到更新数据页面√	/employee/2	GET
    @RequestMapping(value = "/{updateID}" , method = RequestMethod.GET)
    public String updatePage(@PathVariable("updateID") Integer updateID , Model model){
        Employee emp = employeeServiceNorm.getEmpByID(updateID);
        model.addAttribute("employee",emp);
        return "restful/employee_update";
    }

    //执行更新√	/employee	PUT
    @RequestMapping(value = "/updateSave" , method = RequestMethod.PUT)
    public void updateSave(Employee employee , HttpServletResponse response){
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            if (employeeServiceNorm.update(employee)) {
                writer.write("更新成功！");
            }
        }catch (Exception e){
            assert writer != null;
            writer.write("更新失败！");
        }
    }
}
