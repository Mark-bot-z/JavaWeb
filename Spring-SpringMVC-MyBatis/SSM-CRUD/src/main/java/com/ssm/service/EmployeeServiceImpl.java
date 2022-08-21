package com.ssm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.daos.mappers.EmployeeMapper;
import com.ssm.daos.pojo.Employee;
import com.ssm.service.norm.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper empMapper;

    @Override
    public PageInfo<Employee> findEmployeesByPageNums(Integer pageNums) {
        PageHelper.startPage(pageNums,10);
        List<Employee> employees = empMapper.selectByExample(null);
        return new PageInfo<>(employees, 5);
    }

    @Override
    public void addEmployee(Employee employee) {
        empMapper.insert(employee);
    }
}
