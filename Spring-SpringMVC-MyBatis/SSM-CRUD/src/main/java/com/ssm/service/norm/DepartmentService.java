package com.ssm.service.norm;

import com.ssm.daos.pojo.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findDepartments();
}
