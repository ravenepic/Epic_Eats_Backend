package com.epic.eats.portal.utilities;

import com.epic.eats.portal.dtos.RestaurantMenuDTO;
import com.epic.eats.portal.entities.RestaurantMenuEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMenuMapper {
    RestaurantMenuMapper INSTANCE = Mappers.getMapper(RestaurantMenuMapper.class);

    RestaurantMenuDTO entityToDTO(RestaurantMenuEntity entity);
    RestaurantMenuEntity dtoToEntity(RestaurantMenuDTO dto);
}