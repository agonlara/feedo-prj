package com.feedo.back.infraestructure.persistence_mongodb.repositories;

import com.feedo.back.infraestructure.persistence_mongodb.entities.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDocument, String> {

}
