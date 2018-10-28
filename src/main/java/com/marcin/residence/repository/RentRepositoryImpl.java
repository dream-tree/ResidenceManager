package com.marcin.residence.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Rent;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing, adding and updating rent for a given apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Repository
public class RentRepositoryImpl implements RentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets a Rent for a given Apartment.
     *
     * @param apartmentId database id of an Apartment
     * @return Rent for a given Apartment
     */
    @Override
    public Rent getRent(int apartmentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Rent rent = currentSession.get(Rent.class, apartmentId);
        return rent;
    }

    /**
     * Saves a Rent for a given Apartment in the database.
     *
     * @param theRent Rent for saving in the database
     */
    @Override
    public void saveRent(Rent theRent) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theRent);
    }
}