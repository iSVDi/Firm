package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirmController {


    //  Departments
    @PostMapping("department/create")
    String createDepartment(@RequestBody Department department) {
        return "Create department";
    }

    @GetMapping("department/read/{id}")
    String readDepartment(@PathVariable int id) {
        return "readDepartment";
    }

    @PutMapping("department/update")
    String updateDepartment(@RequestBody Department department) {
        return "updateDepartment";
    }

    @DeleteMapping("department/delete/{id}")
    String deleteDepartment(@PathVariable int id) {
        return "deleteDepartment";
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
