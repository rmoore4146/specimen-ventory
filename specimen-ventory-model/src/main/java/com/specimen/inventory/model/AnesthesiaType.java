package com.specimen.inventory.model;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public enum AnesthesiaType {

    ISOFLURANE_USP("Isoflurane, USP"),
    KETAMINE_XYLAZINE("Ketamine/Xylamine (80mg/8/mg/mL)"),
    CHLORAL_HYDRATE("Chloral Hydrate (7%)"),
    PENTOBARBITAL("Pentobarbital (50mg/mL)");

    private final String medicine;

    AnesthesiaType(String v) {
        medicine = v;
    }

    public String getMedicine() {
        return medicine;
    }

    public static AnesthesiaType fromValue(String v) {
        for (AnesthesiaType c: AnesthesiaType.values()) {
            if (c.medicine.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
