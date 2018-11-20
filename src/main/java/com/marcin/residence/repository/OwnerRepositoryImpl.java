package com.marcin.residence.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Owner;
import com.marcin.residence.entity.OwnerMailingAddress;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing, adding, updating and deleting an owner (or Owner-s).
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Repository
public class OwnerRepositoryImpl implements OwnerRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets a single Owner from the database based on the Owner id.
     *
     * @param theId database id of an Owner
     * @return an Owner with the given id
     */
    @Override
    public Owner getOwner(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Owner theOwner = currentSession.get(Owner.class, theId);
        return theOwner;
    }

    /**
     * Saves a new Owner in the database.
     *
     * @param theOwner a new Owner to be saved in the database
     */
    @Override
    public void saveOwner(Owner theOwner) {
        Session currentSession = sessionFactory.getCurrentSession();
        int ownerId = theOwner.getId();
        currentSession.saveOrUpdate(theOwner);
        if (ownerId == 0) {
            OwnerMailingAddress theOwnerMailingAddress = new OwnerMailingAddress();
            theOwnerMailingAddress.setOwner(theOwner);
            currentSession.save(theOwnerMailingAddress);
        }
    }

    /**
     * Deletes an Owner from the database.
     *
     * @param theId database id of an Owner to be deleted
     */
    @Override
    public void deleteOwner(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery(
                "DELETE FROM Owner WHERE id = :ownerId")
                .setParameter("ownerId", theId)
                .executeUpdate();
    }

    /**
     * Gets all Owners from the database.
     *
     * @return a list of Owners retrieved from the database
     */
    @Override
    public List<Owner> getOwners() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Owner> theQuery = currentSession.createQuery(
                "FROM Owner ORDER BY lastName", Owner.class);
        List<Owner> owners = theQuery.getResultList();
        return owners;
    }

    /**
     * Searches Owners in the database based on the user input typed
     * in the searching bar.
     *
     * @param theSearchName string of characters typed by user
     *      in the searching bar
     * @return a list of Owners retrieved from the database, fulfilling
     *      the criteria of the user query
     */
    @Override
    public List<Owner> searchOwners(String theSearchName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Owner> theQuery = null;
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            // search for firstName or lastName, case insensitive
            theQuery = currentSession.createQuery(
                    "FROM Owner "
                            + "WHERE lower(firstName) LIKE :theName "
                            + "OR lower(lastName) LIKE :theName "
                            + "OR id LIKE :theName",
                            Owner.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        } else {
            // if theSearchName is empty, get all Owners
            theQuery = currentSession.createQuery(
                    "FROM Owner ORDER BY lastName", Owner.class);
        }
        List<Owner> owners = theQuery.getResultList();
        return owners;
    }
}