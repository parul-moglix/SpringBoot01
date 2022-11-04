package com.jdbcProject.SpringbootJDBC.Repository;

import com.jdbcProject.SpringbootJDBC.Model.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAll();

    public Employee findById(int id);

    public int deleteByID(int id);

    public int save(Employee employee);
}
