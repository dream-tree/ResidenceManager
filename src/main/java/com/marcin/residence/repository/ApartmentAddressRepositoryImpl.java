package com.marcin.residence.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing, adding and updating the apartment address.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Repository
public class ApartmentAddressRepositoryImpl implements ApartmentAddressRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets an apartment address from the database based on the apartment id.
     *
     * @param theApartmentId database id of an apartment
     * @return an address of an apartment
     */
    @Override
    public ApartmentAddress getApartmentAddress(int theApartmentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        ApartmentAddress theApartmentAddress =
                currentSession.get(ApartmentAddress.class, theApartmentId);
        return theApartmentAddress;
    }

    /**
     * Saves or updates an apartment address in the database.
     *
     * @param theApartmentAddress an address of a given apartment
     *      to be saved or updated in the database
     */
    @Override
    public void saveApartmentAddress(ApartmentAddress theApartmentAddress) {
          Session currentSession = sessionFactory.getCurrentSession();
          int theApartmentId = theApartmentAddress.getId();
          Apartment theApartment = currentSession.get(Apartment.class, theApartmentId);
          theApartmentAddress.setApartment(theApartment);
          currentSession.saveOrUpdate(theApartmentAddress);
    }
}
