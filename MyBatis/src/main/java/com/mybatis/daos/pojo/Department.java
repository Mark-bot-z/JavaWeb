package com.mybatis.daos.pojo;

import java.util.List;

public class Department {

    private Integer did;
    private String deptName;
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
               "did=" + did +
               ", deptName='" + deptName + '\'' +
               ", employees=" + employees +
               '}';
    }

    public Department() {
    }

    public Department(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
