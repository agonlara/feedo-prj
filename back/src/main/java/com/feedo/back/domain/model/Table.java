package com.feedo.back.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Table {
    
    private String id;
    private Restaurant restaurant;
    private TableType type;

}
