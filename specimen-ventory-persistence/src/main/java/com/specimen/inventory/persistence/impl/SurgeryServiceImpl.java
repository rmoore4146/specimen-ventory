package com.specimen.inventory.persistence.impl;

import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.service.SurgeryService;
import com.specimen.inventory.service.exception.SpecimenServiceException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * user: ryan.moore
 * date: 10/22/12
 */
public class SurgeryServiceImpl implements SurgeryService {

    private static final Logger logger = Logger.getLogger(SurgeryServiceImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Surgery createSurgery(Surgery surgery) throws SpecimenServiceException {

        logger.debug("Inserting new Surgery object");
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(surgery);
        transaction.commit();

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
