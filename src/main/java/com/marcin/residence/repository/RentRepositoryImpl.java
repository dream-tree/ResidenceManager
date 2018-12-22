package com.marcin.residence.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Rent;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing, adding and updating (calculating) rent for a given apartment.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Repository
public class RentRepositoryImpl implements RentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets a rent for given apartment.
     *
     * @param apartmentId database id of an apartment
     * @return rent for a given apartment
     */
    @Override
    public Rent getRent(int apartmentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Rent rent = currentSession.get(Rent.class, apartmentId);
        return rent;
    }

    /**
     * Saves a rent for given apartment in the database.
     *
     * @param theRent rent for saving in the database
     */
    @Override
    public void saveRent(Rent theRent) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theRent);
    }

    /**
     * Gets all rents for all apartments in order to calculate current
     * apartments liabilities.
     *
     * @return list of Rent objects
     */
    @Override
    public List<Rent> getAllRents() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Rent> list = currentSession.createQuery(
                "SELECT NEW Rent(rent.id, rent.monthlyTotalRent) FROM Rent rent",
                Rent.class).getResultList();
        return list;
    }
}