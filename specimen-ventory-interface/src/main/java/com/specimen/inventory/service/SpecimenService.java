package com.specimen.inventory.service;

import com.specimen.inventory.model.Specimen;

import java.util.List;

/**
 * user: ryan.moore
 * date: 10/25/12
 */
public interface SpecimenService {

    List<Specimen> getAllSpecimens();

    Specimen getSpecimenById(Long id);
}
