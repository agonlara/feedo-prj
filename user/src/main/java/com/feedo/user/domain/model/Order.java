package com.feedo.user.domain.model;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public final class Order {

    private String id;
    private LocalDateTime requestDate;
    private boolean delivered;
    private boolean inProcess;
    private LocalDateTime deliveryDate;
    private int numTable;
    private List<Product> products;
    private float price = this.getPrice();

    //Fem que Order sigui un Singleton
    private static Order instance;
    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }


    private float getPrice () {
        return products.stream().map(Product::getPrice).reduce(0F, Float::sum); //controlar NullPointer
    }

}


