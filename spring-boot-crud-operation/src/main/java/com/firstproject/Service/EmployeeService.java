package com.firstproject.Service;

import com.firstproject.model.Employee;
import com.firstproject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        List<Employee> employee=new ArrayList<Employee>();
        //System.out.println("employee1");
        employeeRepository.findAll().forEach(employee1 -> employee.add(employee1));
        //System.out.println("employee22");
        return employee;
    }

    public Employee getEmployeeByID(int id) {
        return employeeRepository.findById(id).get();
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    public void saveOrUpdate(Employee employee) {
        employeeRepository.save(employee);
    }
    public void update(Employee employee, int id){
        employeeRepository.save(employee);
    }
}
