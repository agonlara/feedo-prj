package com.feedo.back.infraestructure.persistence_mongodb.entities;

import com.feedo.back.domain.model.Command;
import com.feedo.back.domain.model.Product;
import com.feedo.back.domain.model.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Data
@NoArgsConstructor // because of framework
@Document(collection = "commands")
public class CommandDocument {

    @Id
    private String id;
    private LocalDateTime requestDate;
    private LocalDateTime deliveryDate;
    private boolean deliverd;

    @DBRef
    private TableDocument table;

    @DBRef
    private List<ProductDocument> products;

    public CommandDocument(Command command) {
        id = command.getId();
        table = new TableDocument(command.getTable());
        requestDate = command.getRequestDate();
        deliveryDate = command.getDeliveryDate();
        deliverd = command.isDeliverd();
        products = command.getProducts().stream().map(ProductDocument::new)
                .collect(Collectors.toList());
    }

    public Command toCommand() {
        return Command.builder().id(id)
                .table(table.toTable())
                .requestDate(requestDate)
                .deliveryDate(deliveryDate)
                .deliverd(deliverd)
                .products(products.stream().map(ProductDocument::toProduct)
                        .collect(Collectors.toList()))
                .build();
    }

}
