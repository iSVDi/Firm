package com.example.demo.controller;

import com.example.demo.model.Department;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirmController {

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

}
