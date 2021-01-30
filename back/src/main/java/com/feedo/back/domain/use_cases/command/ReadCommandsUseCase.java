package com.feedo.back.domain.use_cases.command;

import com.feedo.back.domain.model.Command;
import com.feedo.back.domain.model.Restaurant;

import java.util.stream.Stream;

public interface ReadCommandsUseCase {

    Stream<Command> readCommandsInProcess(Restaurant restaurant);

    Stream<Command> readDeliveredCommands(Restaurant restaurant);

}
