package com.example.backend.controller;

import com.example.backend.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.backend.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // POST
    @PostMapping
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.savePayment(payment), HttpStatus.CREATED);
    }
    // GET all
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
    // GET  by id
    @GetMapping("{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") long paymentId) {
        return new ResponseEntity<>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
    }
    // PUT  by id
    @PutMapping("{id}")
    public ResponseEntity<Payment> updatePaymentById(@PathVariable("id") long id
            , @RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.updatePayment(payment, id), HttpStatus.OK);
    }
    // DELETE  by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePayment(@PathVariable("id") long id) {
        paymentService.deletePayment(id);
        return new ResponseEntity<>("Payment deleted successfully!", HttpStatus.OK);
    }
}

