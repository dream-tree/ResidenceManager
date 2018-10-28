package com.marcin.residence.service;

import com.marcin.residence.entity.OwnerMailingAddress;

/**
 * Provides the service for accessing, adding and updating the OwnerMailingAddress.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface OwnerMailingAddressService {

    /**
     * Gets an OwnerMailingAddress from the database based on the Owner id.
     *
     * @param theOwnerId database id of an Owner
     * @return mailing address of an Owner
     */
    OwnerMailingAddress getOwnerMailingAddress(int theOwnerId);

    /**
     * Saves or updates an OwnerMailingAddress in the database.
     *
     * @param theOwnerMailingAddress a mailing address of a given Owner
     *      to be saved or updated in the database
     */
    void saveOwnerMailingAddress(OwnerMailingAddress theOwnerMailingAddress);

}
