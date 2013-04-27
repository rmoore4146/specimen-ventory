package com.specimen.inventory.persistence.impl;

import com.specimen.inventory.model.TableColumnDefinition;
import com.specimen.inventory.service.TableColumnDefinitionService;
import com.specimen.inventory.service.exception.TableColumnDefinitionException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * user: ryan.moore@sparcedge.com
 * date: 4/27/13
 */
@Service("surgeryService")
@Transactional("transactionManager")
public class TableColumnDefinitionServiceImpl implements TableColumnDefinitionService {

    private static final Logger logger = Logger.getLogger(TableColumnDefinitionServiceImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public TableColumnDefinition getTableColumnDefinitionById(Long id) throws TableColumnDefinitionException {

        logger.debug("Fetching TableColumnDefinition object by id:" + id);
        Session session = sessionFactory.getCurrentSession();
        TableColumnDefinition tableColumnDefinition = null;

        try {
            tableColumnDefinition = (TableColumnDefinition) session.get(TableColumnDefinition.class, id);
        } catch (HibernateException he) {
            throw new TableColumnDefinitionException("Error while fetching TableColumnDefinition by id", he);
        }

        return tableColumnDefinition;
    }

    @Override
    public TableColumnDefinition getTableColumnDefinitionByColumnName(String columnName) throws TableColumnDefinitionException {

        String queryStr = "SELECT tcd FROM TableColumnDefinition as tcd WHERE tcd.columnName = :columnName";
        logger.debug("Fetching TableColumnDefinition object by column name: " + columnName);
        TableColumnDefinition tableColumnDefinition;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(queryStr);
            query.setParameter("columnName", columnName);
            tableColumnDefinition = (TableColumnDefinition) query.uniqueResult();
        } catch (HibernateException he) {
            throw new TableColumnDefinitionException("Error fetching TableColumnDefinition object by column name: ", he);
        }

        return tableColumnDefinition;
    }

    @Override
    public TableColumnDefinition saveTableColumnDefinition(TableColumnDefinition tableColumnDefinition) throws TableColumnDefinitionException {

        logger.debug("Inserting new TableColumnDefinition object");
        Session session = sessionFactory.getCurrentSession();

        if (tableColumnDefinition != null) {
            try {
                session.saveOrUpdate(tableColumnDefinition);
            } catch (HibernateException e) {
                throw new TableColumnDefinitionException("Exception caught while saving or updating TableColumnDefinition", e);
            }
        } else {
            throw new TableColumnDefinitionException("TableColumnDefinition was null when attempting to save or update.");
        }

        session.flush();

        return tableColumnDefinition;
    }

    @Override
    public void deleteTableColumnDefinition(Long id) throws TableColumnDefinitionException {

        logger.debug("Deleting TableColumnDefinition object");
        Session session = sessionFactory.getCurrentSession();

        if (id != null) {
            try {
                TableColumnDefinition tableColumnDefinition = (TableColumnDefinition) session.get(TableColumnDefinition.class, id);
                session.delete(tableColumnDefinition);
            } catch (HibernateException e) {
                throw new TableColumnDefinitionException("Exception caught while deleting TableColumnDefinition", e);
            }
        } else {
            throw new TableColumnDefinitionException("TableColumnDefinition was null when attempting to save or update.");
        }

        session.flush();
    }

    @Override
    public List<TableColumnDefinition> getAllTableColumnDefinitions() throws TableColumnDefinitionException {

        String queryStr = "SELECT tcd FROM TableColumnDefinition as tcd";
        logger.debug("Fetching all TableColumnDefinition objects");
        List<TableColumnDefinition> tableColumnDefinitions = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(queryStr);
            query.setMaxResults(100);
            tableColumnDefinitions = (List<TableColumnDefinition>) query.list();
        } catch (HibernateException he) {
            throw new TableColumnDefinitionException("Error occurred while fetching all TableColumnDefinitions", he);
        }

        return tableColumnDefinitions;
    }
}