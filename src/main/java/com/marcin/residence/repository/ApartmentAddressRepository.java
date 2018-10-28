package com.marcin.residence.repository;

import com.marcin.residence.entity.ApartmentAddress;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding and updating the ApartmentAddress.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentAddressRepository {

    /**
     * Gets an ApartmentAddress from the database based on the Apartment id.
     *
     * @param theApartmentId database id of an Apartment
     * @return an address of an Apartment
     */
    ApartmentAddress getApartmentAddress(int theApartmentId);

    /**
     * Saves or updates an ApartmentAddress in the database.
     *
     * @param theApartmentAddress an address of a given Apartment
     *      to be saved or updated in the database
     */
    void saveApartmentAddress(ApartmentAddress theApartmentAddress);

}
