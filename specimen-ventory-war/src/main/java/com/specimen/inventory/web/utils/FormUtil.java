package com.specimen.inventory.web.utils;

import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.model.SurgeryType;

import java.util.HashSet;
import java.util.Set;

/**
 * user: ryan.moore@sparcedge.com
 * date: 4/25/13
 */
public class FormUtil {

    public static void fixSurgeryTypes(Surgery surgery) {

        Set<SurgeryType> originalSurgeryTypes = surgery.getSurgeryTypes();
        Set<SurgeryType> validSurgeryTypes = new HashSet<SurgeryType>();
        for(SurgeryType type:originalSurgeryTypes) {
            if (type != null) {
                validSurgeryTypes.add(type);
            }
        }
        surgery.setSurgeryTypes(validSurgeryTypes);
    }
}
