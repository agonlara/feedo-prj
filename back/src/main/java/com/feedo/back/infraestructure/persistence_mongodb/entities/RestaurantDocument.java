package com.feedo.back.infraestructure.persistence_mongodb.entities;

import com.feedo.back.domain.model.Restaurant;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor // because of framework
@Document(collection = "restaurants")
public class RestaurantDocument {

    @Id
    private String id;
    private String name;
    @DBRef
    private List<ProductDocument> products;

    public RestaurantDocument(String id) {
        this.id = id;
    }

    public RestaurantDocument(Restaurant restaurant) {
        id = restaurant.getId();
        name = restaurant.getName();
        products = restaurant.getProducts().stream().map(ProductDocument::new)
                .collect(Collectors.toList());
    }

    public Restaurant toRestaurant() {
        return Restaurant.builder().id(id)
                .name(name)
                .products(products.stream().map(ProductDocument::toProduct).collect(Collectors.toList()))
                .build();
    }
}
