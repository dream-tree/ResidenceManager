package com.marcin.residence.account.clearance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing liabilities for a given Apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Repository
public class ResidenceLiabilitiesRepositoryImpl implements ResidenceLiabilitiesRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets a list of liabilities for a given Apartment.
     *
     * @param theApartmentId database id of an Apartment
     * @return list of an Apartment liabilities
     */
    @Override
    public List<ResidenceLiabilities> getLiabilities(int theApartmentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<ResidenceLiabilities> transactionList =
                currentSession.createQuery(
                        "SELECT r FROM ResidenceLiabilities r "
                                + "WHERE r.apartment.id=:apartmentId ",
                                ResidenceLiabilities.class)
                .setParameter("apartmentId", theApartmentId)
                .getResultList();
        return transactionList;
    }
}