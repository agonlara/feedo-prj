package com.feedo.user.domain.model;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public class Order {

    private String id;
    private LocalDateTime requestDate;
    private boolean delivered;
    private boolean inProcess;
    private LocalDateTime deliveryDate;
    private int numTable;
    private List<Product> products;
    private float price = this.getPrice();


    public List<Product> checkOrder() {
        return products;
    }

    private float getPrice () {
        return products.stream().map(Product::getPrice).reduce(0F, Float::sum); //controlar NullPointer
    }

}


