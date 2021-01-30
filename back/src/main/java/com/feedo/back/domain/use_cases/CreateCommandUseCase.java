package com.feedo.back.domain.use_cases;

import com.feedo.back.domain.model.Command;

public interface CreateCommandUseCase {

    Command create(Command command);

}
