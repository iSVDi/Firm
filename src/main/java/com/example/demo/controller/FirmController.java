package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.DepartmentView;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeProjection;
import com.example.demo.service.FirmService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping
@AllArgsConstructor
@Validated
public class FirmController {

    private final FirmService firmService;

    //  Departments
    @PostMapping("department/create")
    void createDepartment(@RequestBody Department department) {
        firmService.createDepartment(department);
    }

    @GetMapping("department/read/{id}")
    DepartmentView readDepartment(@PathVariable UUID id) {
        return firmService.readDepartment(id);
    }

    @PutMapping("department/update")
    void updateDepartment(@RequestBody Department department) {
        firmService.updateDepartment(department);
    }

    @DeleteMapping("department/delete/{id}")
    void deleteDepartment(@PathVariable UUID id) {
        firmService.deleteDepartment(id);
    }

    //  Employs
    @PostMapping("employee/create/{department_id}")
    void createEmployee(@RequestBody Employee employee, @PathVariable UUID department_id) {
        firmService.createEmployee(employee, department_id);
    }

    @GetMapping("employee/read/{id}")
    EmployeeProjection readEmployee(@PathVariable UUID id) {
        return firmService.readEmployee(id);
    }

    @PutMapping("employee/update")
    void updateEmployee(@RequestBody Employee employee) {
        firmService.updateEmployee(employee);
    }

    @DeleteMapping("employee/delete/{id}")
    void deleteEmployee(@PathVariable UUID id) {
        firmService.deleteEmployee(id);
    }

}
