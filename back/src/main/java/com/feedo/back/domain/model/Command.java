package com.feedo.back.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class Command {

    private String id;
    private Table table;
    private LocalDateTime requestDate;
    private LocalDateTime deliveryDate;
    private boolean deliverd;
    //private float price;
    private List<Product> products;

    public float getPrice(){
        return products.stream().map(Product::getPrice).reduce(0F, Float::sum);
    }

    public void deliver(){
        this.deliverd = true;
        this.deliveryDate = LocalDateTime.now();
    }

}
