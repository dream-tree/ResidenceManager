package com.marcin.residence.service;

import java.util.List;

import com.marcin.residence.entity.Apartment;

/**
 * Provides the service for accessing, adding, updating and deleting
 * an Apartment (or Apartment-s).
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentService {

    /**
     * Gets a single apartment from the database based on the apartment id.
     *
     * @param theApartmentId database id of an apartment
     * @return an apartment retrieved from the database
     */
    Apartment getSingleApartment(int theApartmentId);

    /**
     * Gets all apartments of a given owner from the database
     * based on the owner id.
     *
     * @param theOwnerId database id of an owner
     * @return list of apartments retrieved from the database
     */
    List<Apartment> getOwnerApartments(int theOwnerId);

    /**
     * Gets all apartments from the database.
     *
     * @return list of all apartments retrieved from the database
     */
    List<Apartment> getAllApartments();

    /**
     * Saves or updates a single apartment in the database.
     *
     * @param theApartment an apartment to be saved or updated in the database
     */
    void saveApartment(Apartment theApartment);

    /**
     * Deletes a single apartment from the database based on the id of an apartment.
     *
     * @param theApartmentId id of an apartment to be deleted from the database
     */
    void deleteApartment(int theApartmentId);

}
