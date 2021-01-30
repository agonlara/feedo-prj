package com.feedo.back.infraestructure.persistence_mongodb.repositories;

import com.feedo.back.infraestructure.persistence_mongodb.entities.CommandDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface CommandRepository extends MongoRepository<CommandDocument, String> {

    Stream<CommandDocument> findByRestaurantId(String restaurantId);

    Optional<CommandDocument> findById(String id);

}
