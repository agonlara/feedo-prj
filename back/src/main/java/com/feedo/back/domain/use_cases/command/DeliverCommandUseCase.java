package com.feedo.back.domain.use_cases.command;

import com.feedo.back.domain.model.Command;

public interface DeliverCommandUseCase {

    Command deliver(String id);

}
