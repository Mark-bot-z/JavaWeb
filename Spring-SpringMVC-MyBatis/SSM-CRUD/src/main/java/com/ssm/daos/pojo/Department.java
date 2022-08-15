package com.ssm.daos.pojo;

public class Department {
    private Integer did;

    private String deptName;

    public Integer getDid() {
        return did;
    }

    @Override
    public String toString() {
        return "Department{" +
               "did=" + did +
               ", deptName='" + deptName + '\'' +
               '}';
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Department() {
    }

    public Department(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }
}