package com.shoppingsite.paymentservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MobilePaymentRequest {
    private String mobileNumber;
    private String pin;
    private BigDecimal amount;
}
