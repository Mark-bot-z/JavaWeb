package com.spring.mvc.daos.norm;

import com.spring.mvc.daos.pojo.Employee;

import java.util.List;

public interface EmployeeDaoNorm {

    List<Employee> findEmployees();

    void delEmployee(Integer id);

    boolean instEmp(Employee employee) throws Exception;

    Employee findEmployeeByID(Integer id);

    boolean renewEmp(Employee employee);
}
