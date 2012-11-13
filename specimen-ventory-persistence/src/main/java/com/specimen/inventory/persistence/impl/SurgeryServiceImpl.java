package com.specimen.inventory.persistence.impl;

import com.specimen.inventory.model.Specimen;
import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.service.SpecimenService;
import com.specimen.inventory.service.SurgeryService;
import com.specimen.inventory.service.exception.SpecimenServiceException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * user: ryan.moore
 * date: 10/22/12
 */
@Service("surgeryService")
@Transactional("transactionManager")
public class SurgeryServiceImpl implements SurgeryService {

    private static final Logger logger = Logger.getLogger(SurgeryServiceImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SpecimenService specimenService;

    @Override
    public Surgery createSurgery(Surgery surgery) throws SpecimenServiceException {

        logger.debug("Inserting new Surgery object");
        Session session = sessionFactory.getCurrentSession();

        //first fetch the specimen by its uuid - if doesn't exist: persist it
        Specimen specimen = specimenService.getSpecimenByUUID(surgery.getSpecimen().getAnimalUUID());
        if (specimen == null) {
            surgery.setSpecimen(specimenService.createSpecimen(surgery.getSpecimen()));
        } else {
            surgery.setSpecimen(specimen);
        }

        //now save the surgery entity with the correct join for specimen
        session.save(surgery);

        return surgery;
    }

    @Override
    public Surgery getSurgery(long id) throws SpecimenServiceException {

        logger.debug("Fetching new Surgery object by id:" + id);
        Session session = sessionFactory.getCurrentSession();
        Surgery surgery = (Surgery) session.get(Surgery.class, id);

        return surgery;
    }
}
