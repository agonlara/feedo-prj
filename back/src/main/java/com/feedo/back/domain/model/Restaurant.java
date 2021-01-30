package com.feedo.back.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Restaurant {

    private String id;
    private String name;
    private List<Product> products;

}
