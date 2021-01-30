package com.feedo.back.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Product {

    private String id;
    private String name;
    private float price;
    private boolean available;
    private List<ProductCategory> categories;

}
