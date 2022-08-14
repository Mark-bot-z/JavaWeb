package com.ssm.daos.pojo;

public class Employee {
    private Integer eid;
    private String empName;

    private Integer age;
    private String email;
    private char sex;

    @Override
    public String toString() {
        return "Employee{" +
               "eid=" + eid +
               ", empName='" + empName + '\'' +
               ", age=" + age +
               ", email='" + email + '\'' +
               ", sex=" + sex +
               ", did=" + did +
               '}';
    }

    private Integer did;

    public Employee(Integer eid, String empName, Integer age, String email, char sex) {
        this.eid = eid;
        this.empName = empName;
        this.age = age;
        this.email = email;
        this.sex = sex;
    }

    public Employee() {
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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
        this.email = email;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
}
