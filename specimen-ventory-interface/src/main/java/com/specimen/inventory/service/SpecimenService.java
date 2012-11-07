package com.specimen.inventory.service;

import com.specimen.inventory.model.Specimen;
import com.specimen.inventory.service.exception.SpecimenServiceException;

import java.util.Set;

/**
 * user: ryan.moore
 * date: 10/25/12
 */
public interface SpecimenService {

    Set<Specimen> getAllSpecimens();

    Specimen getSpecimenByUUID(String uuid);

    Specimen createSpecimen(Specimen specimen) throws SpecimenServiceException;
}
