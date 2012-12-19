package com.specimen.inventory.persistence.impl;

import com.specimen.inventory.model.Specimen;
import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.service.SpecimenService;
import com.specimen.inventory.service.SurgeryService;
import com.specimen.inventory.service.exception.SpecimenServiceException;
import com.specimen.inventory.service.exception.SurgeryServiceException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

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
    public Surgery createSurgery(Surgery surgery) throws SurgeryServiceException {

        logger.debug("Inserting new Surgery object");
        Session session = sessionFactory.getCurrentSession();

        //first fetch the specimen by its uuid - if doesn't exist: persist it
        Specimen specimen = specimenService.getSpecimenByUUID(surgery.getSpecimen().getAnimalUUID());
        if (specimen == null) {
            try {
                surgery.setSpecimen(specimenService.createSpecimen(surgery.getSpecimen()));
            } catch (SpecimenServiceException e) {
                throw new SurgeryServiceException("Exception caught while persisting Specimen - " + surgery.getSpecimen().getAnimalUUID(), e);
            }
        } else {
            surgery.setSpecimen(specimen);
        }

        //now save the surgery entity with the correct join for specimen
        session.save(surgery);

        return surgery;
    }

    @Override
    public Surgery getSurgery(long id) {

        logger.debug("Fetching new Surgery object by id:" + id);
        Session session = sessionFactory.getCurrentSession();
        Surgery surgery = (Surgery) session.get(Surgery.class, id);

        return surgery;
    }

    @Override
    public Set<Surgery> listSurgeries() {

        String queryStr = "SELECT s FROM Surgery as s";
        logger.debug("Fetching all surgery objects");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(queryStr);
        Set<Surgery> surgerySet = new HashSet<Surgery>(query.list());

        return surgerySet;
    }

    @Override
    public Set<Surgery> listSurgeryBySpecimenId(Long id) {

        String queryStr = "SELECT s FROM Surgery as s WHERE s.specimen.id = :animalId";
        logger.debug("Fetching Surgery object by specimen id:" + id);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(queryStr);
        query.setParameter("animalId", id);
        Set<Surgery> surgerySet = new HashSet<Surgery>(query.list());

        return surgerySet;
    }

    @Override
    public Set<Surgery> listSurgeryBySpecimenUUID(String uuid) {

        String queryStr = "SELECT s FROM Surgery as s WHERE s.specimen.animalUUID = :animalId";
        logger.debug("Fetching Surgery object by uuid:" + uuid);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(queryStr);
        query.setParameter("animalId", uuid);
        Set<Surgery> surgerySet = new HashSet<Surgery>(query.list());

        return surgerySet;
    }

    @Override
    public Surgery updateSurgery(Surgery surgery) throws SurgeryServiceException {

        logger.debug("Updating surgery with id - " + surgery.getId());
        Session session = sessionFactory.getCurrentSession();

        //first fetch the specimen by its uuid - if doesn't exist: persist it
        Specimen specimen = specimenService.getSpecimenByUUID(surgery.getSpecimen().getAnimalUUID());
        if (specimen == null) {
            try {
                surgery.setSpecimen(specimenService.createSpecimen(surgery.getSpecimen()));
            } catch (SpecimenServiceException e) {
                throw new SurgeryServiceException("Exception caught while persisting Specimen - " + surgery.getSpecimen().getAnimalUUID(), e);
            }
        } else {
            surgery.setSpecimen(specimen);
        }

        //now merge/update the surgery entity with the correct join for specimen
        Surgery mergedSurgery = (Surgery) session.merge(surgery);

        return surgery;
    }

    @Override
    public void deleteSurgery(Long surgeryId) throws SurgeryServiceException {

        Surgery surgery = getSurgery(surgeryId);

        //get session
        Session session = sessionFactory.getCurrentSession();

        try {
            //attempt a delete, throw exception if fails
            session.delete(surgery);
        } catch (HibernateException he) {
            String message = "An error occurred while deleting surgery with id - " + surgeryId;
            logger.error(message, he);
            throw new SurgeryServiceException(message, he);
        }
    }
}
