package com.jdbcProject.SpringbootJDBC.Repository;

import com.jdbcProject.SpringbootJDBC.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final String GET_EMPLOYEE="SELECT * FROM employee";
    private static final String GET_EMPLOYEE_BY_ID="SELECT * FROM employee WHERE ID=?";
    private static final String DELETE_EMPLOYEE_BY_ID="DELETE FROM employee WHERE ID=?";
    private static final String INSERT_EMPLOYEE="INSERT INTO employee(id,name,department,salary) VALUES (?,?,?,?)";

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(GET_EMPLOYEE, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public Employee findById(int id) {
        return jdbcTemplate.queryForObject(GET_EMPLOYEE_BY_ID,new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public int deleteByID(int id) {
        return jdbcTemplate.update(DELETE_EMPLOYEE_BY_ID,id);
    }

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update(INSERT_EMPLOYEE,employee.getId(),employee.getName(),employee.getDepartment(),employee.getSalary());
    }
}
