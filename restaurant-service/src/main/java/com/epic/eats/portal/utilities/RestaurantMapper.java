package com.epic.eats.portal.utilities;

import com.epic.eats.portal.dtos.RestaurantDTO;
import com.epic.eats.portal.entities.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = RestaurantMenuMapper.class)
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDTO entityToDTO(RestaurantEntity restaurantEntity);

    @Mapping(source = "menus", target="menuItems")
    RestaurantDTO entityToDTOWithMenus(RestaurantEntity restaurantEntity);

    RestaurantEntity DTOtoEntity(RestaurantDTO restaurantDTO);
}
