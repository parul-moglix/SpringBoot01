package com.jdbcProject.SpringbootJDBC.Controller;

import com.jdbcProject.SpringbootJDBC.Model.Employee;
import com.jdbcProject.SpringbootJDBC.Repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeContoller {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employees/get")
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
    @GetMapping("/employees/get/{id}")
    public Employee findById(@PathVariable("id") int id) {
        return employeeDao.findById(id);
    }
    @DeleteMapping("/employees/delete/{id}")
    public int deleteByID(@PathVariable("id") int id) {
        return employeeDao.deleteByID(id);
    }
    @PostMapping("/employees/save")
    public int save(@RequestBody Employee employee) {
        return employeeDao.save(employee);
    }
}
