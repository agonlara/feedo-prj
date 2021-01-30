package com.feedo.back.domain.use_cases;

import com.feedo.back.domain.model.Table;

public interface ReadTableUseCase {

    Table readTable(String tableId);

}
