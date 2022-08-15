package com.ssm.daos.pojo;

public class Employee {
    private Integer eid;

    private String empName;

    public Employee(Integer eid, String empName, Integer age, String email, String sex, Integer did) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.email = email;
        this.sex = sex;
        this.did = did;
    }

    public Employee() {
    }

    private Integer age;

    private String email;

    private String sex;

    private Integer did;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEmpName() {
        return empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "eid=" + eid +
               ", empName='" + empName + '\'' +
               ", age=" + age +
               ", email='" + email + '\'' +
               ", sex='" + sex + '\'' +
               ", did=" + did +
               '}';
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
}