package com.example.demo.repository;

import com.example.demo.model.Department;
import com.example.demo.model.DepartmentView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    DepartmentView getDepartmentById(UUID id);
}
