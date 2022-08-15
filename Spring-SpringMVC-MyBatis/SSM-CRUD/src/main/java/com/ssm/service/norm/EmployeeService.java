package com.ssm.service.norm;


import com.github.pagehelper.PageInfo;
import com.ssm.daos.pojo.Employee;

public interface EmployeeService {


    PageInfo<Employee> findEmployeesByPageNums(Integer pageNums);




}
