package com.specimen.inventory.service;

import com.specimen.inventory.model.TableColumnDefinition;
import com.specimen.inventory.service.exception.TableColumnDefinitionException;

import java.util.List;

/**
 * user: ryan.moore@sparcedge.com
 * date: 4/27/13
 */
public interface TableColumnDefinitionService {

    TableColumnDefinition getTableColumnDefinitionById(Long id) throws TableColumnDefinitionException;

    TableColumnDefinition getTableColumnDefinitionByColumnName(String columnName) throws TableColumnDefinitionException;

    TableColumnDefinition saveTableColumnDefinition(TableColumnDefinition tableColumnDefinition) throws TableColumnDefinitionException;

    void deleteTableColumnDefinition(Long id) throws TableColumnDefinitionException;

    List<TableColumnDefinition> getAllTableColumnDefinitions() throws TableColumnDefinitionException;
}
