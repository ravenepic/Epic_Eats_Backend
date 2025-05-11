package com.epic.eats.portal.services;

import com.epic.eats.portal.dtos.RestaurantDTO;
import org.springframework.data.domain.Page;

import java.util.List;


public interface RestaurantService {
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO);
    public RestaurantDTO getRestaurantById(Integer restaurantId);
    public List<RestaurantDTO> getAllRestaurants();

}
