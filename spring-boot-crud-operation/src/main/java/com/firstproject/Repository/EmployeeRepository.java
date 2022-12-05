package com.firstproject.Repository;

import com.firstproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {             //entity, pk type
}
