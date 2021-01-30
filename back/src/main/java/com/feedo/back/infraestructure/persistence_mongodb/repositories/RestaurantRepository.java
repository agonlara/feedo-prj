package com.feedo.back.infraestructure.persistence_mongodb.repositories;

import com.feedo.back.infraestructure.persistence_mongodb.entities.RestaurantDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantRepository extends MongoRepository<RestaurantDocument, String> {

}
