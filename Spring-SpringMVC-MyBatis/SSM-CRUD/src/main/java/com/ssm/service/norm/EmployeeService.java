package com.ssm.service.norm;


import com.github.pagehelper.PageInfo;
import com.ssm.daos.pojo.Employee;

public interface EmployeeService {

    PageInfo<Employee> findEmployeesByPageNums(Integer pageNums);

    void addEmployee(Employee employee);

    Integer delEmployee(Integer eid);

    void updateEmployee(Employee employee);

    Integer delBatchEmp(String eids);
}
