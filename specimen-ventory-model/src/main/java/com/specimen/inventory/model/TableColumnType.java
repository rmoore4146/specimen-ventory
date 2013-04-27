package com.specimen.inventory.model;

/**
 * user: ryan.moore@sparcedge.com
 * date: 4/27/13
 */
public enum TableColumnType {

    TEXT("Text"),
    DATE("Date"),
    NUMBER("Number");

    private final String type;

    TableColumnType(String v) {
        type = v;
    }

    public String getType() {
        return type;
    }

    public static TableColumnType fromValue(String v) {
        for (TableColumnType c: TableColumnType.values()) {
            if (c.type.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
