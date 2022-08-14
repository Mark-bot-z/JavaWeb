package com.ssm.services;

import com.github.pagehelper.PageInfo;
import com.ssm.daos.pojo.Employee;

public interface EmployeeServiceNorm {

    default void say(){
        System.out.println("hello world");
    }

    PageInfo<Employee> findEmployeeByPageNums(Integer pageNumbers);
}
