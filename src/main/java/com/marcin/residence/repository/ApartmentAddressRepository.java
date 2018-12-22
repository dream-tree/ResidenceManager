package com.marcin.residence.repository;

import com.marcin.residence.entity.ApartmentAddress;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding and updating the apartment address.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
public interface ApartmentAddressRepository {

    /**
     * Gets an apartment address from the database based on the apartment id.
     *
     * @param theApartmentId database id of an apartment
     * @return an address of an apartment
     */
    ApartmentAddress getApartmentAddress(int theApartmentId);

    /**
     * Saves or updates an apartment address in the database.
     *
     * @param theApartmentAddress an address of a given apartment
     *      to be saved or updated in the database
     */
    void saveApartmentAddress(ApartmentAddress theApartmentAddress);

}
