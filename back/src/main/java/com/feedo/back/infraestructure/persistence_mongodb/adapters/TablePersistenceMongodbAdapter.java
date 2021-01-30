package com.feedo.back.infraestructure.persistence_mongodb.adapters;

import com.feedo.back.domain.model.Table;
import com.feedo.back.domain.ports.TablePersistencePort;
import com.feedo.back.infraestructure.persistence_mongodb.entities.TableDocument;
import com.feedo.back.infraestructure.persistence_mongodb.repositories.TableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class TablePersistenceMongodbAdapter implements TablePersistencePort {

    private final TableRepository tableRepository;

    @Override
    public Stream<Table> findAll() {
        return tableRepository.findAll().stream()
                .map(TableDocument::toTable);
    }

    @Override
    public Stream<Table> findByRestaurantId(String restaurantId) {
        return tableRepository.findByRestaurantId(restaurantId)
                .map(TableDocument::toTable);
    }

    @Override
    public Optional<Table> findById(String id) {
        return tableRepository.findById(id)
                .map(TableDocument::toTable);
    }

    @Override
    public Table create(Table table) {
        return tableRepository.save(new TableDocument(table))
                .toTable();
    }
}
