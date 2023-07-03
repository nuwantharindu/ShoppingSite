package com.shoppingsite.paymentservice.service;

import jakarta.ws.rs.NotFoundException;
import com.shoppingsite.paymentservice.dto.CreditCardPaymentRequest;
import com.shoppingsite.paymentservice.dto.MobilePaymentRequest;
import com.shoppingsite.paymentservice.dto.PaymentResponse;
import com.shoppingsite.paymentservice.model.CreditCardPayment;
import com.shoppingsite.paymentservice.model.MobilePayment;
import com.shoppingsite.paymentservice.model.Payment;
import com.shoppingsite.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentResponse payWithCreditCard(CreditCardPaymentRequest creditCardPaymentRequest) {
        CreditCardPayment payment = new CreditCardPayment();
        payment.setAmount(creditCardPaymentRequest.getAmount());
        // Here you would call the payment gateway to process the transaction using the creditCardPaymentRequest object
        // If the transaction is successful, save the payment object to the database
        paymentRepository.save(payment);
        return new PaymentResponse(payment.getId(), "Credit Card", payment.getAmount());
    }

    public PaymentResponse getPayment(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new NotFoundException("Payment not found"));
        return new PaymentResponse(payment.getId(), payment.getPaymentType(), payment.getAmount());
    }

    public PaymentResponse refund(Long id) {
        // Here you would call the payment gateway to process the refund
        // If the refund is successful, delete the payment object from the database
        paymentRepository.deleteById(id);
        return new PaymentResponse(id, "Refund successful");
    }
}

