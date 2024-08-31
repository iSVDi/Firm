package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String firstName;
    String lastName;
    String position;
    BigDecimal salary;

    @Setter
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
