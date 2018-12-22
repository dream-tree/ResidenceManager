package com.marcin.residence.repository;

import java.util.List;

import com.marcin.residence.entity.Owner;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding, updating and deleting an owner (or owners).
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
public interface OwnerRepository {

    /**
     * Gets a single owner from the database based on the id of an owner.
     *
     * @param theId database id of an owner
     * @return an owner with the given id
     */
    Owner getOwner(int theId);

    /**
     * Saves a new owner in the database.
     *
     * @param theOwner a new owner to be saved in the database
     */
    void saveOwner(Owner theOwner);

    /**
     * Deletes an owner from the database.
     *
     * @param theId database id of an owner to be deleted
     */
    void deleteOwner(int theId);

    /**
     * Gets all owners from the database.
     *
     * @return a list of owners retrieved from the database
     */
    List<Owner> getOwners();

    /**
     * Searches owners in the database based on the user input typed
     * in the searching bar.
     *
     * @param theSearchName string of characters typed by user
     *      in the searching bar
     * @return a list of owners retrieved from the database, fulfilling
     *      the criteria of the user query
     */
    List<Owner> searchOwners(String theSearchName);
}