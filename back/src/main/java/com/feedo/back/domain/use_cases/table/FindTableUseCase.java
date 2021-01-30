package com.feedo.back.domain.use_cases.table;

import com.feedo.back.domain.model.Table;

public interface FindTableUseCase {

    Table findTableById(String tableId);

}
