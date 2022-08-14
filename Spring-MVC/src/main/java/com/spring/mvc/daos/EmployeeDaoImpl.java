package com.spring.mvc.daos;

import com.spring.mvc.daos.norm.EmployeeDaoNorm;
import com.spring.mvc.daos.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "EmployeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDaoNorm {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Employee> findEmployees() {
        return template.query("SELECT * FROM empdb.emp",new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public void delEmployee(Integer id) {
        template.update("DELETE FROM empdb.emp WHERE id = ?",id);
    }

    @Override
    public boolean instEmp(Employee employee) throws Exception{
        return template.update("INSERT INTO empdb.emp(LASTNAME, EMAIL, GENDER) VALUES (?,?,?)",
                employee.getLastName(),
                employee.getEmail(),
                employee.getGender()
        ) > 0;
    }

    @Override
    public Employee findEmployeeByID(Integer id) {
        return template.queryForObject("SELECT * FROM empdb.emp WHERE id = ?",new BeanPropertyRowMapper<>(Employee.class),id);
    }

    @Override
    public boolean renewEmp(Employee employee) {
        return template.update("UPDATE empdb.emp SET lastName = ? , email = ? , gender = ? WHERE ID = ?",
                employee.getLastName(),
                employee.getEmail(),
                employee.getGender(),
                employee.getId()
        ) > 0;
    }
}
