package com.feedo.back.domain.model;

import lombok.Data;

@Data
public class Table {
    
    private String id;
    private Restaurant restaurant;
    private TableType type;

}
