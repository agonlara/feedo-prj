package com.feedo.back.infraestructure.persistence_mongodb.repositories;

import com.feedo.back.infraestructure.persistence_mongodb.entities.TableDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.stream.Stream;

public interface TableRepository extends MongoRepository<TableDocument, String> {

    Stream<TableDocument> findByRestaurantId(String restaurantId);

}
