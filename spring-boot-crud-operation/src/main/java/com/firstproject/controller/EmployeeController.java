package com.firstproject.controller;
import java.util.List;


import com.firstproject.Service.EmployeeService;
import com.firstproject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees/*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    private Employee getEmployee(@PathVariable("id")int id){
        return employeeService.getEmployeeByID(id);
    }
    @DeleteMapping("/employees/{id}")     //creating delete mapping that deletes a specified employee
    private void deleteEmployee(@PathVariable("id")int id){
        employeeService.delete(id);
    }
    @PostMapping("/employees")
    private int saveEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdate(employee);
        return employee.getId();
    }
    @PutMapping("/employees")
    private Employee update(@RequestBody Employee employee){
        employeeService.saveOrUpdate(employee);
        return employee;
    }
}
