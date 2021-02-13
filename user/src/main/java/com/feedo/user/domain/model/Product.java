package com.feedo.user.domain.model;


import lombok.Getter;
import java.util.List;

@Getter


public class Product {

    private int id;
    private float price;
    private boolean available;
    private String name;
    private List<Tag> tags;

}
