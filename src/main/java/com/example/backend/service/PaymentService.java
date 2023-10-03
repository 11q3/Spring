package com.example.backend.service;

import com.example.backend.model.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    Payment savePayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentById(long id);
    Payment updatePayment(Payment payment, long id);
    void deletePayment(long id);
}
