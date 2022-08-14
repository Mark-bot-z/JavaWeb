package com.spring.mvc.services.norm;

import com.spring.mvc.daos.pojo.Employee;

import java.util.List;

public interface EmployeeServiceNorm {

    List<Employee> getAllEmployees();

    void delEmpByID(Integer id);

    boolean save(Employee employee) throws Exception;

    Employee getEmpByID(Integer id);

    boolean update(Employee employee);
}
