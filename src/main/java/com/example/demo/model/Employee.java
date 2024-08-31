package com.example.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    Integer id;
    String firstName;
    String lastName;
    String position;
    BigDecimal salary;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
