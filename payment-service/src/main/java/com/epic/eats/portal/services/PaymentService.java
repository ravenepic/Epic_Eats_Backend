package com.epic.eats.portal.services;

import com.epic.eats.portal.dtos.OrderDTO;

public interface PaymentService {

    void processPayment(OrderDTO orderDTO);
}
