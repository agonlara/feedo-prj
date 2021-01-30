package com.feedo.back.domain.ports;

import com.feedo.back.domain.model.Command;

import java.util.Optional;
import java.util.stream.Stream;

public interface CommandPersistencePort {

    Stream<Command> findByRestaurantId(String restaurantId);

    Optional<Command> findById(String id);

    Command create(Command entity);

    Command update(Command entity);

}
