package com.feedo.user.domain.model;

import java.util.List;
import lombok.Getter;

@Getter
public class Restaurant {

    private int id;
    private String name;
    private boolean open;
    private List<Product> products;

}
