package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    EmployeeProjection getEmployeeById(UUID id);
}
