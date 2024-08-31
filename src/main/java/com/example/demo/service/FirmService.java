package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.DepartmentView;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeProjection;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class FirmService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    public DepartmentView readDepartment(UUID id) {
        // TODO handle error
        DepartmentView department = departmentRepository.getDepartmentById(id);
        return department;
    }
    public void updateDepartment(Department department) {
        if (departmentRepository.existsById(department.getId())) {
            departmentRepository.save(department);
        }
    }

    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }

    public void createEmployee(Employee employee, UUID department_id) {
        var department = departmentRepository.findById(department_id).get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    public EmployeeProjection readEmployee(UUID id) {
//        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        EmployeeProjection employee = employeeRepository.getEmployeeById(id);
        return employee;

    }

    public void updateEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
        Department department = employeeOptional.get().getDepartment();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }


}
