package com.specimen.inventory.model;

/**
 * user: ryan.moore
 * date: 10/22/12
 */
public enum SurgeryType {

    VIRUS_SURGERY("Virus Surgery"),
    HEAD_SURGERY("Head Surgery"),
    LESION_SURGERY("Lesion Surgery"),
    ELECTRODE_SURGERY("Electrode Surgery"),
    OPTRODE_SURGERY("Optrode Surgery"),
    TRACE_SURGERY("Tracer Surgery"),
    CANNULA_SURGERY("Cannula Surgery"),
    IV_SURGERY("IV Surgery");

    private final String surgeryType;

    SurgeryType(String v) {
        surgeryType = v;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public static SurgeryType fromValue(String v) {
        for (SurgeryType c: SurgeryType.values()) {
            if (c.surgeryType.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
