package com.example.Springbootexample.controller;

import com.example.Springbootexample.entity.Department;
import com.example.Springbootexample.service.DepartmentService;
import com.example.Springbootexample.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){

        return departmentService.saveDepartment(department);
    }
}
