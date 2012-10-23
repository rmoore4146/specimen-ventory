package com.specimen.inventory.model;

/**
 * user: ryan.moore
 * date: 10/22/12
 */
public enum SurgeryType {

    HEAD_SURGERY("Head Surgery"),
    IV_SURGERY("IV Surgery");

    private final String value;

    SurgeryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SurgeryType fromValue(String v) {
        for (SurgeryType c: SurgeryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
