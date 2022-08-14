package com.mybatis.daos.mapper;

import com.mybatis.daos.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> findAllEmps();

    Employee findEmpInfoByID(@Param("eid") Integer ID);

    Employee findEmpByDID(@Param("did") Integer did);
}
