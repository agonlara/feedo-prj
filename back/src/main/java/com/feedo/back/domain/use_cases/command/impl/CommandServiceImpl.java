package com.feedo.back.domain.use_cases.command.impl;

import com.feedo.back.domain.model.Command;
import com.feedo.back.domain.model.Restaurant;
import com.feedo.back.domain.ports.CommandPersistencePort;
import com.feedo.back.domain.use_cases.command.CreateCommandUseCase;
import com.feedo.back.domain.use_cases.command.DeliverCommandUseCase;
import com.feedo.back.domain.use_cases.command.ReadCommandsUseCase;
import lombok.AllArgsConstructor;

import java.util.stream.Stream;

@AllArgsConstructor
public class CommandServiceImpl implements ReadCommandsUseCase, CreateCommandUseCase, DeliverCommandUseCase {

    private final CommandPersistencePort commandPersistence;

    @Override
    public Command create(Command command) {
        return commandPersistence.create(command);
    }

    @Override
    public Command deliver(String id) {
        Command command = commandPersistence.readById(id)
                .orElseThrow(() -> new CommandNotFoundException(id));
        command.deliver();
        return commandPersistence.update(command);
    }

    @Override
    public Stream<Command> readCommandsInProcess(Restaurant restaurant) {
        return commandPersistence.readByRestaurantId(restaurant.getId())
                .filter(command -> !command.isDeliverd());
    }

    @Override
    public Stream<Command> readDeliveredCommands(Restaurant restaurant) {
        return commandPersistence.readByRestaurantId(restaurant.getId())
                .filter(Command::isDeliverd);
    }

    public static class CommandNotFoundException extends RuntimeException {
        private static final String DESCRIPTION = "Command Not Found Exception (404)";
        public CommandNotFoundException(String id) {
            super(DESCRIPTION + ". " + "Command with id: " + id + " does not exist!");
        }
    }

}
