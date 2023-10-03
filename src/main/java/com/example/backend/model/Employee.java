package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "LastName", nullable = false)
    private String lastName;
    @Column(name = "FirstName", nullable = false)
    private String firstName;
    @Column(name = "MiddleName", nullable = false)
    private String middleName;
    @Column(name = "Position", nullable = false)
    private String position;
    @Column(name = "Salary", nullable = false)
    private int salary;


    @OneToMany(mappedBy = "employee")
    private List<Payment> payments;
}
