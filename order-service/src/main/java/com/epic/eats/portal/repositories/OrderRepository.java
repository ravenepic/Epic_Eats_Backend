package com.epic.eats.portal.repositories;

import com.epic.eats.portal.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity,UUID> {
}
