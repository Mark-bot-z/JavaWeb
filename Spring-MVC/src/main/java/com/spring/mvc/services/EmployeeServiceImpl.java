package com.spring.mvc.services;

import com.spring.mvc.daos.norm.EmployeeDaoNorm;
import com.spring.mvc.daos.pojo.Employee;
import com.spring.mvc.services.norm.EmployeeServiceNorm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeServiceNorm {

    @Autowired
    @Qualifier(value = "EmployeeDaoImpl")
    private EmployeeDaoNorm employeeDaoNorm;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDaoNorm.findEmployees();
    }

    @Override
    public void delEmpByID(Integer id) {
        employeeDaoNorm.delEmployee(id);
    }

    @Override
    public boolean save(Employee employee) throws Exception{
        return employeeDaoNorm.instEmp(employee);
    }

    @Override
    public Employee getEmpByID(Integer id) {
        return employeeDaoNorm.findEmployeeByID(id);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeDaoNorm.renewEmp(employee);
    }
}
