package com.feedo.back.domain.use_cases.command;

import com.feedo.back.domain.model.Command;
import com.feedo.back.domain.model.Table;

import java.util.stream.Stream;

public interface FindCommandsUseCase {

    Stream<Command> findCommandsInProcess(Table table);

    Stream<Command> findDeliveredCommands(Table table);

}
