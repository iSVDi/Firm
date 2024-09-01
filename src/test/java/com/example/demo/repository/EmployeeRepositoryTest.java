package com.example.demo.repository;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void EmployeeRepository_Create() {
        Department department = Department.builder().id(UUID.randomUUID()).name("department").build();
        Employee employee = Employee.builder()
                .firstName("Alex")
                .lastName("Petrov")
                .position("developer")
                .salary(BigDecimal.valueOf(50000)).build();

        Department savedDepartment = departmentRepository.save(department);
        employee.setDepartment(savedDepartment);
        Employee savedEmployee = employeeRepository.save(employee);

        assertNotNull(savedEmployee);
        assertNotNull(savedEmployee.getDepartment());
    }

    @Test
    void EmployeeRepository_Read() {
        Department department = Department.builder().id(UUID.randomUUID()).name("department").build();
        Employee employee = Employee.builder()
                .firstName("Alex")
                .lastName("Petrov")
                .position("developer")
                .salary(BigDecimal.valueOf(50000)).build();

        Department savedDepartment = departmentRepository.save(department);
        employee.setDepartment(savedDepartment);
        Employee savedEmployee = employeeRepository.save(employee);

        Assertions.assertNotNull(employeeRepository.findById(savedEmployee.getId()).get());
    }


    @Test
    void EmployeeRepository_Update() {
        Department department = Department.builder().id(UUID.randomUUID()).name("department").build();
        Employee employee = Employee.builder()
                .firstName("Alex")
                .lastName("Petrov")
                .position("developer")
                .salary(BigDecimal.valueOf(50000)).build();

        Department savedDepartment = departmentRepository.save(department);
        employee.setDepartment(savedDepartment);
        employeeRepository.save(employee);

        Employee updatedEmployee = Employee.builder()
                .firstName("Petr")
                .lastName("Alexsov")
                .position("QA")
                .salary(BigDecimal.valueOf(20000)).build();
        Employee savedUpdatedEmployee = employeeRepository.save(updatedEmployee);

        assertNotEquals(employee.getFirstName(), savedUpdatedEmployee.getFirstName());
        assertNotEquals(employee.getLastName(), savedUpdatedEmployee.getLastName());
        assertNotEquals(employee.getPosition(), savedUpdatedEmployee.getPosition());
        assertNotEquals(employee.getSalary(), savedUpdatedEmployee.getSalary());
        assertNotEquals(employee.getDepartment(), savedUpdatedEmployee.getDepartment());
    }

    @Test
    void EmployeeRepository_Delete() {
        Employee employee = Employee.builder()
                .firstName("Alex")
                .lastName("Petrov")
                .position("developer")
                .salary(BigDecimal.valueOf(50000)).build();

        Employee savedEmployee = employeeRepository.save(employee);
        employeeRepository.delete(savedEmployee);
        Assertions.assertTrue(employeeRepository.findById(savedEmployee.getId()).isEmpty());
    }

}
