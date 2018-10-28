package com.marcin.residence.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing, adding and updating the ApartmentAddress.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Repository
public class ApartmentAddressRepositoryImpl implements ApartmentAddressRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets an ApartmentAddress from the database based on the Apartment id.
     *
     * @param theApartmentId database id of an Apartment
     * @return an address of an Apartment
     */
    @Override
    public ApartmentAddress getApartmentAddress(int theApartmentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        ApartmentAddress theApartmentAddress =
                currentSession.get(ApartmentAddress.class, theApartmentId);
        return theApartmentAddress;
    }

    /**
     * Saves or updates an ApartmentAddress in the database.
     *
     * @param theApartmentAddress an address of a given Apartment
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
