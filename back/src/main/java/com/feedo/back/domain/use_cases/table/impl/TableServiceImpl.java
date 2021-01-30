package com.feedo.back.domain.use_cases.table.impl;

import com.feedo.back.domain.model.Table;
import com.feedo.back.domain.ports.TablePersistencePort;
import com.feedo.back.domain.use_cases.table.FindTableUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TableServiceImpl implements FindTableUseCase {

    private final TablePersistencePort tablePersistence;

    @Override
    public Table findTableById(String tableId) {
        return tablePersistence.findById(tableId)
                .orElseThrow(() -> new TableNotFoundException(tableId));
    }

    public static class TableNotFoundException extends RuntimeException {
        private static final String DESCRIPTION = "Table Not Found Exception (404)";
        public TableNotFoundException(String id) {
            super(DESCRIPTION + ". " + "Table with id: " + id + " does not exist!");
        }
    }

}
