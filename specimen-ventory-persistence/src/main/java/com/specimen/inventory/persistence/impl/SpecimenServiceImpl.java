package com.specimen.inventory.persistence.impl;

import com.specimen.inventory.model.Specimen;
import com.specimen.inventory.service.SpecimenService;
import com.specimen.inventory.service.exception.SpecimenServiceException;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
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
 * date: 11/7/12
 */
@Service("specimenService")
@Transactional("transactionManager")
public class SpecimenServiceImpl implements SpecimenService {

    private static final Logger logger = Logger.getLogger(SpecimenServiceImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Set<Specimen> getAllSpecimens() {
        String queryStr = "SELECT s FROM Specimen as s";
        logger.debug("Fetching all Specimen rows");
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(queryStr);
        Set<Specimen> resultSet = new HashSet<Specimen>(query.list());

        for(Specimen specimen:resultSet) {
            Hibernate.initialize(specimen.getSurgeryList());
        }
        return resultSet;
    }

    @Override
    public Specimen getSpecimenByUUID(String uuid) {

        String queryStr = "SELECT s FROM Specimen as s WHERE s.animalUUID = :animalId";
        logger.debug("Fetching Specimen object by uuid:" + uuid);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(queryStr);
        query.setParameter("animalId", uuid);
        Specimen specimen = (Specimen) query.uniqueResult();

        return specimen;
    }

    @Override
    public Specimen createSpecimen(Specimen specimen) throws SpecimenServiceException {

        logger.debug("Inserting new Specimen object");
        Session session = sessionFactory.getCurrentSession();
        session.save(specimen);
        session.close();

        return specimen;
    }
}
