package com.specimen.inventory.service;

import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.service.exception.SpecimenServiceException;

/**
 * user: ryan.moore
 * date: 10/16/12
 */
public interface SurgeryService {

    Surgery createSurgery(Surgery surgery) throws SpecimenServiceException;

    Surgery getSurgery(long id) throws SpecimenServiceException;
}
