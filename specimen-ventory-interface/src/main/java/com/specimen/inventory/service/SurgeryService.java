package com.specimen.inventory.service;

import com.specimen.inventory.model.SurgeryForm;
import com.specimen.inventory.service.exception.SpecimenServiceException;

/**
 * user: ryan.moore
 * date: 10/16/12
 */
public interface SurgeryService {

    SurgeryForm createSurgery(SurgeryForm surgery) throws SpecimenServiceException;

    SurgeryForm fetchSurgery(long id) throws SpecimenServiceException;
}
