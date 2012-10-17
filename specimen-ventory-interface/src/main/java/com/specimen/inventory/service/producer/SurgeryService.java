package com.specimen.inventory.service.producer;

import com.specimen.inventory.service.exception.SpecimenServiceException;

/**
 * user: ryan.moore
 * date: 10/16/12
 */
public interface SurgeryService {

    Boolean createSurgeryEntry() throws SpecimenServiceException;
}
