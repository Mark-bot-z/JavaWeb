package com.mybatis.daos.mapper;

import com.mybatis.daos.pojo.Department;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
    Department findDepartmentByID(@Param("did") Integer did);

    Department findDepartmentByIDInfo(@Param("did") Integer id);
}
