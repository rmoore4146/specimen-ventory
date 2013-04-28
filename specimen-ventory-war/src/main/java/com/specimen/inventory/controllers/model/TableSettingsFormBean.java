package com.specimen.inventory.controllers.model;

import com.specimen.inventory.model.TableColumnDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * user: ryan.moore@sparcedge.com
 * date: 4/27/13
 */
public class TableSettingsFormBean {

    List<TableColumnDefinition> tableColumnDefinitions;

    public TableSettingsFormBean(List<TableColumnDefinition> tableColumnDefinitions) {
        getTableColumnDefinitions().addAll(tableColumnDefinitions);
    }
    public List<TableColumnDefinition> getTableColumnDefinitions() {
        if (tableColumnDefinitions == null) {
            tableColumnDefinitions = new ArrayList<TableColumnDefinition>();
        }
        return tableColumnDefinitions;
    }

    public void setTableColumnDefinitions(List<TableColumnDefinition> tableColumnDefinitions) {
        this.tableColumnDefinitions = tableColumnDefinitions;
    }
}
