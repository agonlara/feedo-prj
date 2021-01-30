package com.feedo.back.infraestructure.persistence_mongodb.entities;

import com.feedo.back.domain.model.Product;
import com.feedo.back.domain.model.ProductCategory;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor // because of framework
@Document(collection = "products")
public class ProductDocument {

    @Id
    private String id;
    private String name;
    private float price;
    private boolean available;
    private List<ProductCategory> categories;

    public ProductDocument(String id) {
        this.id = id;
    }

    public ProductDocument(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        available = product.isAvailable();
        categories = product.getCategories();
    }

    public Product toProduct() {
        return Product.builder().id(id)
                .name(name)
                .price(price)
                .available(available)
                .categories(categories)
                .build();
    }

}
