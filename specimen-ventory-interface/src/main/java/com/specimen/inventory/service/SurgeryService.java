package com.specimen.inventory.service;

import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.service.exception.SurgeryServiceException;

import java.util.Set;

/**
 * user: ryan.moore
 * date: 10/16/12
 */
public interface SurgeryService {

    Surgery createSurgery(Surgery surgery) throws SurgeryServiceException;

    Surgery getSurgery(long id) throws SurgeryServiceException;

    Set<Surgery> listSurgeries();

    Set<Surgery> listSurgeryBySpecimenId(Long id);

    Set<Surgery> listSurgeryBySpecimenUUID(String uuid);

    Surgery updateSurgery(Surgery surgery) throws SurgeryServiceException;
}
