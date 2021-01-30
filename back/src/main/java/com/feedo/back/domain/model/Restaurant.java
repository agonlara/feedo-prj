package com.feedo.back.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Restaurant {

    private String id;
    private String name;
    private List<Product> products;

}
