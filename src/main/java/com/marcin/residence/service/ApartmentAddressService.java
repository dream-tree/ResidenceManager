package com.marcin.residence.service;

import com.marcin.residence.entity.ApartmentAddress;

/**
 * Provides the service for accessing, adding and updating the apartment address.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentAddressService {

    /**
     * Gets an apartment address from the database based on the id of
     * an apartment.
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
