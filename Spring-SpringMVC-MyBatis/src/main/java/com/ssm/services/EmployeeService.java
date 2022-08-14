package com.ssm.services;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.daos.mapper.EmployeeMapper;
import com.ssm.daos.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ,timeout = 10)
public class EmployeeService implements EmployeeServiceNorm{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void say() {
        System.out.println("java nb");
        EmployeeServiceNorm.super.say();
    }

    @Override
    public PageInfo<Employee> findEmployeeByPageNums(Integer pageNumbers) {
        PageHelper.startPage(pageNumbers,3);
        List<Employee> employees = employeeMapper.getEmployees();
        return new PageInfo<>(employees,3);
    }

}
