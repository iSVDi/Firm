package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class FirmService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    public Department readDepartment(UUID id) {
        // TODO handle error
        var dep = departmentRepository.findById(id);
        return dep.get();
    }

    public List<Department> readAllDepartments() {
        return departmentRepository.findAll();
    }


    public void updateDepartment(Department department) {
        if (departmentRepository.existsById(department.getId())) {
            departmentRepository.save(department);
        }
    }

    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }

}
