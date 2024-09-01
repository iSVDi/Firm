package com.example.demo.repository;

import com.example.demo.model.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void DepartmentRepository_Create() {
        Department department = Department.builder()
                .id(UUID.randomUUID())
                .name("cool department").build();

        Department savedDepartment = departmentRepository.save(department);
        Assertions.assertNotNull(savedDepartment);
    }

    @Test
    void DepartmentRepository_Read() {
        Department department = Department.builder()
                .id(UUID.randomUUID())
                .name("cool department").build();

        Department savedDepartment = departmentRepository.save(department);
        Assertions.assertNotNull(departmentRepository.findById(savedDepartment.getId()).get());
    }

    @Test
    void DepartmentRepository_Update() {
        Department department = Department.builder()
                .id(UUID.randomUUID())
                .name("cool department").build();

        Department savedDepartment = departmentRepository.save(department);

        Department updatedDepartment = Department.builder()
                .id(savedDepartment.getId())
                .name("the most cool department").build();

        Department savedUpdatedDepartment = departmentRepository.save(updatedDepartment);

        Assertions.assertNotEquals(department.getName(), savedUpdatedDepartment.getName());
    }

    @Test
    void DepartmentRepository_Delete() {
        Department department = Department.builder()
                .id(UUID.randomUUID())
                .name("cool department").build();

        Department savedDepartment = departmentRepository.save(department);
        departmentRepository.delete(savedDepartment);

        Assertions.assertTrue(departmentRepository.findById(savedDepartment.getId()).isEmpty());

    }

}
