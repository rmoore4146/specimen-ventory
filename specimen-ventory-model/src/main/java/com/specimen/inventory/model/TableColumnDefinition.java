package com.specimen.inventory.model;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;

/**
 * user: ryan.moore@sparcedge.com
 * date: 4/27/13
 */
public class TableColumnDefinition {

    private Long id;
    private Boolean enabled;
    private TableColumnType type;
    private Boolean editable;
    private String columnName;
    private Boolean viewedByDefault;

    public Boolean getViewedByDefault() {
        return viewedByDefault;
    }

    public void setViewedByDefault(Boolean viewedByDefault) {
        this.viewedByDefault = viewedByDefault;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Boolean isEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public TableColumnType getType() {
        return type;
    }

    public void setType(TableColumnType type) {
        this.type = type;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
