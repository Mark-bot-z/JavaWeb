package com.ssm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.daos.mappers.EmployeeMapper;
import com.ssm.daos.pojo.Employee;
import com.ssm.daos.pojo.EmployeeExample;
import com.ssm.service.norm.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
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

    @Override
    public Integer delEmployee(Integer eid) {
       return empMapper.deleteByPrimaryKey(eid);
    }

    @Override
    public void updateEmployee(Employee employee) {
        empMapper.updateByPrimaryKeySelective(employee);
    }

    @Override
    public Integer delBatchEmp(String eids) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEidIn(Arrays.stream(eids.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList()
                )
        );
        return empMapper.deleteByExample(employeeExample);
    }
}
