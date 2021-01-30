package com.feedo.back.domain.use_cases.command;

import com.feedo.back.domain.model.Command;
import com.feedo.back.domain.model.Restaurant;

import java.util.stream.Stream;

public interface FindCommandsUseCase {

    Stream<Command> findCommandsInProcess(Restaurant restaurant);

    Stream<Command> findDeliveredCommands(Restaurant restaurant);

}
