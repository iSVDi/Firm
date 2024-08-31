package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
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
    Department readDepartment(@PathVariable UUID id) {
        return firmService.readDepartment(id);
    }

    @GetMapping()
    List<Department> readAllDepartment() {
        return firmService.readAllDepartments();
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
    @PostMapping("employee/create")
    String createEmployee(@RequestBody Employee employee) {
        return "Create Employee";
    }

    @GetMapping("employee/read/{id}")
    String readEmployee(@PathVariable int id) {
        return "readEmployee";
    }

    @PutMapping("employee/update")
    String updateEmployee(@RequestBody Employee employee) {
        return "updateEmployee";
    }

    @DeleteMapping("employee/delete/{id}")
    String deleteEmployee(@PathVariable int id) {
        return "deleteEmployee";
    }

}
