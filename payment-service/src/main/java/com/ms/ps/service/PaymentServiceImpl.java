package com.ms.ps.service;

import com.ms.ps.dto.PaymentRequest;
import com.ms.ps.dto.PaymentResponse;
import com.ms.ps.entity.Payment;
import com.ms.ps.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setId(paymentRequest.getId());
        payment.setAmount(paymentRequest.getAmount());
        payment.setOrderId(paymentRequest.getOrderId());
        payment.setPaymentStatus(processPayment(payment.getId(), payment.getAmount()));
        paymentRepository.save(payment);
        return new PaymentResponse(payment.getId(), payment.getOrderId(), payment.getAmount(), payment.getPaymentStatus());
    }

    private String processPayment(UUID id, double amount) {
        if(amount>0) return "success";
        else return  "fail";
    }
}
