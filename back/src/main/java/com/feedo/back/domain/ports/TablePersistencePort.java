package com.feedo.back.domain.ports;

import com.feedo.back.domain.model.Table;

import java.util.Optional;
import java.util.stream.Stream;

public interface TablePersistencePort {

    Stream<Table> findAll();

    Stream<Table> findByRestaurantId(String id);

    Optional<Table> findById(String id);

    Table create(Table entity);

}
