package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue
    Integer id;
    String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;
}
