package com.marcin.residence.repository;

import java.util.List;

import com.marcin.residence.entity.Apartment;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding, updating and deleting an Apartment (or Apartment-s).
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentRepository {

    /**
     * Gets a single Apartment from the database based on the Apartment id.
     *
     * @param theApartmentId database id of an Apartment
     * @return an Apartment with the given id
     */
    Apartment getSingleApartment(int theApartmentId);

    /**
     * Gets all Apartments belonging to a given Owner based on the Owner id.
     *
     * @param theOwnerId database id of an Owner
     * @return all Apartments of a given Owner
     */
    List<Apartment> getOwnerApartments(int theOwnerId);

    /**
     * Gets all Apartments from the database.
     *
     * @return all Apartments in the database
     */
    List<Apartment> getAllApartments();

    /**
     * Saves a new Apartment or updates an existing one in the database.
     *
     * @param theApartment an Apartment to be saved or updated
     */
    void saveApartment(Apartment theApartment);

    /**
     * Deletes an Apartment of a given id from the database.
     *
     * @param theApartmentId database id of an Apartment
     */
    void deleteApartment(int theApartmentId);

}
