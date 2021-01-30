package com.feedo.back.domain.ports;

import com.feedo.back.domain.model.Table;

import java.util.Optional;
import java.util.stream.Stream;

public interface TablePersistencePort {

    Stream<Table> readAll();

    Stream<Table> readByRestaurantId(String id);

    Optional<Table> readById(String id);

    Table create(Table entity);

}
