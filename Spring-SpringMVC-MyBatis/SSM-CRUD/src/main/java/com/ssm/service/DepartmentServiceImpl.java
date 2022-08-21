package com.ssm.service;

import com.ssm.daos.mappers.DepartmentMapper;
import com.ssm.daos.pojo.Department;
import com.ssm.service.norm.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> findDepartments() {
        return departmentMapper.selectByExample(null);
    }
}
