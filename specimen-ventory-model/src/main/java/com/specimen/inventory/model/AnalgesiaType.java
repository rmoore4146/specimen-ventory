package com.specimen.inventory.model;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public enum AnalgesiaType {

    KETOPROFEN("Ketoprofen (5mg/mL)");

    private final String medicine;

    AnalgesiaType(String v) {
        medicine = v;
    }

    public String getMedicine() {
        return medicine;
    }

    public static AnalgesiaType fromValue(String v) {
        for (AnalgesiaType c: AnalgesiaType.values()) {
            if (c.medicine.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
