package com.marcin.residence.service;

import java.util.List;

import com.marcin.residence.entity.Owner;

/**
 * Provides the service for accessing, adding, updating, deleting and searching 
 * an Owner (or Owner-s).
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface OwnerService {

    /**
     * Gets an Owner from the database based on the Owner id.
     *
     * @param theOwnerId database id of an Owner
     * @return an Owner retrieved from the database
     */
    Owner getOwner(int theOwnerId);

    /**
     * Saves or updates an Owner in the database.
     *
     * @param theOwner an Owner to be saved or updated in the database
     */
    void saveOwner(Owner theOwner);

    /**
     * Deletes an Owner from the database based on the Owner id.
     *
     * @param theOwnerId id of an Owner to be deleted from the database
     */
    void deleteOwner(int theOwnerId);

    /**
     * Gets all Owner-s from the database.
     *
     * @return list of Owner-s retrieved from the database
     */
    List<Owner> getOwners();

    /**
     * Searches Owners in the database based on the user input typed
     * in the searching bar.
     *
     * @param theSearchName string of characters typed by user
     *      in the searching bar
     * @return a list of Owners retrieved from the database, fulfilling
     *      the criteria of the user query
     */
    List<Owner> searchOwners(String theSearchName);

}
