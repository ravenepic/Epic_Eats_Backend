package com.epic.eats.portal.services.impl;

import com.epic.eats.portal.entities.OrderEntity;
import com.epic.eats.portal.repositories.OrderRepository;
import com.epic.eats.portal.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void processOrder(OrderEntity orderEntity) {
        this.orderRepository.save(orderEntity);
    }
}
