package com.epic.eats.portal.repositories;

import com.epic.eats.portal.entities.RestaurantMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenuEntity,Integer> {
}
