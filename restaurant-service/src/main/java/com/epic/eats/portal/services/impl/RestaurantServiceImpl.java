package com.epic.eats.portal.services.impl;

import com.epic.eats.portal.dtos.RestaurantDTO;
import com.epic.eats.portal.entities.RestaurantEntity;
import com.epic.eats.portal.services.RestaurantService;
import com.epic.eats.portal.repositories.RestaurantRepository;
import com.epic.eats.portal.utilities.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {
        RestaurantEntity restaurantEntity = RestaurantMapper.INSTANCE.DTOtoEntity(restaurantDTO);
        this.restaurantRepository.save(restaurantEntity);
        return RestaurantMapper.INSTANCE.entityToDTO(restaurantEntity);
    }




    @Override
    public RestaurantDTO getRestaurantById(Integer restaurantId) {
        return RestaurantMapper.INSTANCE.entityToDTOWithMenus(this.restaurantRepository.findById(restaurantId).get());
    }

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
      List<RestaurantEntity> restaurants =  this.restaurantRepository.findAll();
      return restaurants.stream().map( RestaurantMapper.INSTANCE::entityToDTO).toList();
    }
}
