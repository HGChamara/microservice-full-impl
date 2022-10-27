package com.ms.ps.service;

import com.ms.ps.dto.PaymentRequest;
import com.ms.ps.dto.PaymentResponse;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest paymentRequest);
}
