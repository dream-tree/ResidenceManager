package com.marcin.residence.repository;

import java.util.List;

import com.marcin.residence.entity.Owner;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding, updating and deleting an Owner (or Owner-s).
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface OwnerRepository {

    /**
     * Retrieves a single Owner from the database based on the Owner id.
     *
     * @param theId database id of an Owner
     * @return an Owner with the given id
     */
    Owner getOwner(int theId);

    /**
     * Saves a new Owner in the database.
     *
     * @param theOwner a new Owner to be saved in the database
     */
    void saveOwner(Owner theOwner);

    /**
     * Deletes an Owner from the database.
     *
     * @param theId database id of an Owner to be deleted
     */
    void deleteOwner(int theId);

    /**
     * Gets all Owners from the database.
     *
     * @return a list of Owners retrieved from the database
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