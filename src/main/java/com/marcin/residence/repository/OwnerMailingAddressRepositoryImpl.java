package com.marcin.residence.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Owner;
import com.marcin.residence.entity.OwnerMailingAddress;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing, adding and updating the owner mailing address.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Repository
public class OwnerMailingAddressRepositoryImpl implements OwnerMailingAddressRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets an owner mailing address from the database based on the id of an owner.
     *
     * @param theOwnerId database id of an owner
     * @return mailing address of an owner
     */
    @Override
    public OwnerMailingAddress getOwnerMailingAddress(int theOwnerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        OwnerMailingAddress ownerMailingAddress =
                currentSession.get(OwnerMailingAddress.class, theOwnerId);
        return ownerMailingAddress;
    }

    /**
     * Saves or updates an owner mailing address in the database.
     *
     * @param theOwnerMailingAddress a mailing address of a given owner
     *      to be saved or updated in the database
     */
    @Override
    public void saveOwnerMailingAddress(OwnerMailingAddress theOwnerMailingAddress) {
          Session currentSession = sessionFactory.getCurrentSession();
          int theOwnerId = theOwnerMailingAddress.getId();
          Owner theOwner = currentSession.get(Owner.class, theOwnerId);
          theOwnerMailingAddress.setOwner(theOwner);
          currentSession.saveOrUpdate(theOwnerMailingAddress);
    }
}
