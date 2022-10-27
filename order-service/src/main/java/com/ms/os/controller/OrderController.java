package com.ms.os.controller;

import com.ms.os.dto.OrderRequest;
import com.ms.os.dto.OrderResponse;
import com.ms.os.entity.Order;
import com.ms.os.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public OrderResponse setOrder(@RequestBody OrderRequest orderRequest) {
        return  orderService.saveOrder(orderRequest);
    }

}
