package com.example.backend.service.impl;

import com.example.backend.exception.ResourceNotFoundException;
import com.example.backend.model.Payment;
import com.example.backend.repository.PaymentRepository;
import com.example.backend.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImplementation implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImplementation(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
    @Override
    public Payment getPaymentById(long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isPresent())
            return payment.get();
        else
            throw new ResourceNotFoundException("Payment", "Id", id);
    }
    @Override
    public Payment updatePayment(Payment payment, long id) {

        //check if payment is present with given id.
        Payment existingPayment = paymentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Payment", "Id", id));
        existingPayment.setPaymentDate(payment.getPaymentDate());
        existingPayment.setPaymentAmount(payment.getPaymentAmount());
        existingPayment.setEmployee(payment.getEmployee());

        //save existing payment to db
        paymentRepository.save(existingPayment);
        return existingPayment;
    }

    @Override
    public void deletePayment(long id) {
        //check if payment is present with given id.
        paymentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Payment", "Id", id));
        paymentRepository.deleteById(id);
    }
}
