package com.epic.eats.portal.repositories;

import com.epic.eats.portal.entities.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity,Integer> {

}
