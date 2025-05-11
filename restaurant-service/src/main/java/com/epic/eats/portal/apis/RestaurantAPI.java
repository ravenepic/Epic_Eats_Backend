package com.epic.eats.portal.apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.epic.eats.portal.dtos.RestaurantDTO;
import com.epic.eats.portal.repositories.RestaurantRepository;
import com.epic.eats.portal.services.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("restaurants")
@RequiredArgsConstructor
@Slf4j
public class RestaurantAPI {

    private final RestaurantService restaurantService;



    private RestaurantRepository restaurantRepository;


    @PostMapping
    public ResponseEntity<RestaurantDTO> createRestaurant(@Valid @RequestBody RestaurantDTO restaurantDTO){
        RestaurantDTO restaurant = this.restaurantService.createRestaurant(restaurantDTO);
        return new ResponseEntity<RestaurantDTO>(restaurant,HttpStatus.CREATED);
    }

    @GetMapping("/{restaurantId}")
    public RestaurantDTO getRestaurantById(@PathVariable Integer restaurantId){
        RestaurantDTO restaurant = this.restaurantService.getRestaurantById(restaurantId);
        System.out.println(restaurant);
        return restaurant;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurants(){
        return ResponseEntity.ok(this.restaurantService.getAllRestaurants());
    }




}
