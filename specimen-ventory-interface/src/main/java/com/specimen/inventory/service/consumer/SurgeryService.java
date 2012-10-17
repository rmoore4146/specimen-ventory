package com.specimen.inventory.service.consumer;

import com.specimen.inventory.model.IVSurgeryForm;
import com.specimen.inventory.service.exception.SpecimenServiceException;

/**
 * user: ryan.moore
 * date: 10/16/12
 */
public interface SurgeryService {

    Boolean createIVSurgeryEntry(IVSurgeryForm surgeryForm) throws SpecimenServiceException;
}
