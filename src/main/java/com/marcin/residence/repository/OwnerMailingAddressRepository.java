package com.marcin.residence.repository;

import com.marcin.residence.entity.OwnerMailingAddress;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding and updating the OwnerMailingAddress.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface OwnerMailingAddressRepository {

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
