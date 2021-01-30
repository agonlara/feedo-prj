package com.feedo.back.domain.use_cases.table.impl;

import com.feedo.back.domain.model.Table;
import com.feedo.back.domain.ports.TablePersistencePort;
import com.feedo.back.domain.use_cases.table.ReadTableUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TableServiceImpl implements ReadTableUseCase {

    private final TablePersistencePort tablePersistence;

    @Override
    public Table readTableById(String tableId) {
        return tablePersistence.readById(tableId)
                .orElseThrow(() -> new TableNotFoundException(tableId));
    }

    public static class TableNotFoundException extends RuntimeException {
        private static final String DESCRIPTION = "Table Not Found Exception (404)";
        public TableNotFoundException(String id) {
            super(DESCRIPTION + ". " + "Table with id: " + id + " does not exist!");
        }
    }

}
