package com.ms.os.service;

import com.ms.os.dto.*;
import com.ms.os.entity.Order;
import com.ms.os.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{

    public final OrderRepository orderRepository;
    public final RestTemplate restTemplate;

    public OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public OrderResponse saveOrder(OrderRequest orderRequest) {
        OrderDto orderDto = orderRequest.getOrder();

        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setName(orderDto.getName());
        order.setPrice(orderDto.getPrice());
        order.setQuantity(orderDto.getQuantity());

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(UUID.randomUUID());
        paymentDto.setOrderId(order.getId());
        paymentDto.setAmount(order.getPrice() * order.getQuantity());

        PaymentResponse paymentResponse = restTemplate.postForObject("http://localhost:9091/payments/", paymentDto, PaymentResponse.class);
        System.out.println(paymentResponse.getPaymentStatus());
        orderRepository.save(order);

        return new OrderResponse(order.getId(), paymentResponse.getAmount(), paymentResponse.getPaymentStatus());
    }
}
