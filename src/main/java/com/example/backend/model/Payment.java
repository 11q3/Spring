package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "EmployeeId", referencedColumnName = "id")
    private Employee employee;

    @Column(name = "PaymentDate", nullable = false)
    private Date paymentDate;

    @Column(name = "Amount", nullable = false)
    private double paymentAmount;
}
