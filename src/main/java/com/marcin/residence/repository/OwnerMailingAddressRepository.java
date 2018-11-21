package com.marcin.residence.repository;

import com.marcin.residence.entity.OwnerMailingAddress;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding and updating the owner mailing address.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface OwnerMailingAddressRepository {

    /**
     * Gets an owner mailing address from the database based on the id of an owner.
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
