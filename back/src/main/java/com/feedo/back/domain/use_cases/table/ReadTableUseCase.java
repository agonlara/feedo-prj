package com.feedo.back.domain.use_cases.table;

import com.feedo.back.domain.model.Table;

public interface ReadTableUseCase {

    Table readTableById(String tableId);

}
