package com.feedo.back.infraestructure.persistence_mongodb.adapters;

import com.feedo.back.domain.model.Command;
import com.feedo.back.domain.ports.CommandPersistencePort;
import com.feedo.back.infraestructure.persistence_mongodb.entities.CommandDocument;
import com.feedo.back.infraestructure.persistence_mongodb.repositories.CommandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class CommandPersistenceMongodbAdapter implements CommandPersistencePort {

    private final CommandRepository commandRepository;

    @Override
    public Stream<Command> findByTableId(String tableId) {
        return commandRepository.findByTableId(tableId)
                .map(CommandDocument::toCommand);
    }

    @Override
    public Optional<Command> findById(String id) {
        return commandRepository.findById(id)
                .map(CommandDocument::toCommand);
    }

    @Override
    public Command create(Command command) {
        return commandRepository.save(new CommandDocument(command))
                .toCommand();
    }

    @Override
    public Command update(Command command) {
        return commandRepository.save(new CommandDocument(command))
                .toCommand();
    }
}
