package com.feedo.back.domain.ports;

import com.feedo.back.domain.model.Restaurant;

import java.util.stream.Stream;

public interface RestaurantPersistencePort {

    Stream<Restaurant> findAll();

}
