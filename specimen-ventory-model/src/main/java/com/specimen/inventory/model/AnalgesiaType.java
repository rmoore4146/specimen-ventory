package com.specimen.inventory.model;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public enum AnalgesiaType {

    KETOPROFEN("Ketoprofen (5mg/mL)");

    private final String value;

    AnalgesiaType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AnalgesiaType fromValue(String v) {
        for (AnalgesiaType c: AnalgesiaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
