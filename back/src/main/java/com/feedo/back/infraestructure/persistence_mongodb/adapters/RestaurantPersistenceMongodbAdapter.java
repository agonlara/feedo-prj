package com.feedo.back.infraestructure.persistence_mongodb.adapters;

import com.feedo.back.domain.model.Restaurant;
import com.feedo.back.domain.ports.RestaurantPersistencePort;
import com.feedo.back.infraestructure.persistence_mongodb.entities.RestaurantDocument;
import com.feedo.back.infraestructure.persistence_mongodb.repositories.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class RestaurantPersistenceMongodbAdapter implements RestaurantPersistencePort {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Stream<Restaurant> findAll() {
        return restaurantRepository.findAll().stream()
                .map(RestaurantDocument::toRestaurant);
    }

}
