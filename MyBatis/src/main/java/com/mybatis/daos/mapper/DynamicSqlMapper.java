package com.mybatis.daos.mapper;

import com.mybatis.daos.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Mark-Z
 * @version 0.0.1
 * @implNote 动态实现SQL拼接的标签使用
 */
public interface DynamicSqlMapper {

    //if
    List<Employee> getEmpOfConditions1(Employee employee);

    //when
    List<Employee> getEmpOfConditions2(Employee employee);

    //trim
    List<Employee> getEmpOfConditions3(Employee employee);

    //choose、when、otherwise
    List<Employee> getEmpOfConditions4(Employee employee);

    int deleteMoreByArray(@Param("eids") Integer[] eids);

    int insertMoreEmp(@Param("employees") List<Employee> employees);
}
