package com.feedo.back.domain.use_cases;

import com.feedo.back.domain.model.Command;
import com.feedo.back.domain.model.Restaurant;

import java.util.List;

public interface ReadCommandsUseCase {

    List<Command> readCommandsInProcess(Restaurant restaurant);
    List<Command> readDeliveredCommands(Restaurant restaurant);

}
