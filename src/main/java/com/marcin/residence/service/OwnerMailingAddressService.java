package com.marcin.residence.service;

import com.marcin.residence.entity.OwnerMailingAddress;

/**
 * Provides the service for accessing, adding and updating the owner mailing
 * address.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
public interface OwnerMailingAddressService {

    /**
     * Gets an owner mailing address from the database based on the owner id.
     *
     * @param theOwnerId database id of an owner
     * @return mailing address of an owner
     */
    OwnerMailingAddress getOwnerMailingAddress(int theOwnerId);

    /**
     * Saves or updates an owner mailing address in the database.
     *
     * @param theOwnerMailingAddress a mailing address of a given owner
     *      to be saved or updated in the database
     */
    void saveOwnerMailingAddress(OwnerMailingAddress theOwnerMailingAddress);

}
