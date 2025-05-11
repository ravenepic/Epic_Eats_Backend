package com.epic.eats.portal.services;

import com.epic.eats.portal.entities.OrderEntity;

public interface OrderService {
    void processOrder(OrderEntity orderEntity);
}
