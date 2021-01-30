package com.feedo.back.domain.use_cases.restaurant;

import com.feedo.back.domain.model.Restaurant;

import java.util.List;

public interface FindRestaurantUseCase {

    List<Restaurant> findAll();

}
