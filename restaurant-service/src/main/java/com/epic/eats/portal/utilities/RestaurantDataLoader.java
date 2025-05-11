package com.epic.eats.portal.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.epic.eats.portal.entities.RestaurantEntity;
import com.epic.eats.portal.repositories.RestaurantRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class RestaurantDataLoader {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostConstruct
    public void init() {
        try {
            Resource resource = resourceLoader.getResource("classpath:rest.json");
            try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
                String jsonData = FileCopyUtils.copyToString(reader);
                List<RestaurantEntity> restaurantEntities = objectMapper.readValue(jsonData, new TypeReference<List<RestaurantEntity>>() {});
                restaurantRepository.saveAll(restaurantEntities);
                System.out.println("Restaurant data loaded successfully!");
            }
        } catch (Exception e) {
            System.err.println("Error loading restaurant data: " + e.getMessage());
        }
    }
}