package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @NotNull
    String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;
}

