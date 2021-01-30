package com.feedo.back.infraestructure.persistence_mongodb.entities;

import com.feedo.back.domain.model.Table;
import com.feedo.back.domain.model.TableType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "tables")
@NoArgsConstructor
public class TableDocument {

    @Id
    private String id;
    private TableType type;

    @DBRef
    private RestaurantDocument restaurant;

    public TableDocument(Table table) {
        id = table.getId();
        type = table.getType();
        restaurant = new RestaurantDocument(table.getRestaurant());
    }

    public Table toTable() {
        return Table.builder().id(id)
                .type(type)
                .restaurant(restaurant.toRestaurant())
                .build();
    }

}
