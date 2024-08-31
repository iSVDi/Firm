package com.example.demo.model;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();

    String getPosition();

    @Value("#{target.getDepartment.getName}")
    String getDepartmentName();
}
