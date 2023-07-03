package com.shoppingsite.paymentservice.controller;

import com.shoppingsite.paymentservice.dto.CreditCardPaymentRequest;
import com.shoppingsite.paymentservice.dto.MobilePaymentRequest;
import com.shoppingsite.paymentservice.dto.PaymentResponse;
import com.shoppingsite.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/credit")
    public ResponseEntity<PaymentResponse> payWithCreditCard(@RequestBody CreditCardPaymentRequest creditCardPaymentRequest) {
        PaymentResponse paymentResponse = paymentService.payWithCreditCard(creditCardPaymentRequest);
        return new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentStatus(@PathVariable Long id) {
        PaymentResponse paymentResponse = paymentService.getPayment(id);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }

    @PostMapping("/{id}/refund")
    public ResponseEntity<PaymentResponse> refund(@PathVariable Long id) {
        PaymentResponse paymentResponse = paymentService.refund(id);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }
}

