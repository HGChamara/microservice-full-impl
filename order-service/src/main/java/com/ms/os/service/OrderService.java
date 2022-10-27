package com.ms.os.service;

import com.ms.os.dto.OrderRequest;
import com.ms.os.dto.OrderResponse;

public interface OrderService {
    OrderResponse saveOrder(OrderRequest orderRequest);
}
