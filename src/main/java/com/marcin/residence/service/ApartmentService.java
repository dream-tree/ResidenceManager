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
     * Gets a single Apartment from the database based on the Apartment id.
     *
     * @param theApartmentId database id of an Apartment
     * @return an Apartment retrieved from the database
     */
    Apartment getSingleApartment(int theApartmentId);

    /**
     * Gets all Apartment-s of a given Owner from the database
     * based on the Owner id.
     *
     * @param theOwnerId database id of an Owner
     * @return list of Apartment-s retrieved from the database
     */
    List<Apartment> getOwnerApartments(int theOwnerId);

    /**
     * Gets all Apartment-s from the database.
     *
     * @return list of all Apartment-s retrieved from the database
     */
    List<Apartment> getAllApartments();

    /**
     * Saves or updates a single Apartment in the database.
     *
     * @param theApartment an apartment to be saved or updated in the database
     */
    void saveApartment(Apartment theApartment);

    /**
     * Deletes a single Apartment from the database based on the Apartment id.
     *
     * @param theApartmentId id of an Apartment to be deleted from the database
     */
    void deleteApartment(int theApartmentId);

}
