package com.feedo.back.domain.use_cases.restaurant.impl;

import com.feedo.back.domain.model.Restaurant;
import com.feedo.back.domain.ports.RestaurantPersistencePort;
import com.feedo.back.domain.use_cases.restaurant.FindRestaurantUseCase;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RestaurantServiceImpl implements FindRestaurantUseCase {

    private final RestaurantPersistencePort restaurantPersistence;

    @Override
    public List<Restaurant> findAll() {
        return restaurantPersistence.findAll().collect(Collectors.toList());
    }

}
