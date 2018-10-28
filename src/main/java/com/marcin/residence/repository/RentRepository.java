package com.marcin.residence.repository;

import com.marcin.residence.entity.Rent;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding and updating rent for a given apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface RentRepository {

    /**
     * Gets a Rent for a given Apartment.
     *
     * @param apartmentId database id of an Apartment
     * @return Rent for a given Apartment
     */
    Rent getRent(int apartmentId);

    /**
     * Saves a Rent for a given Apartment in the database.
     *
     * @param theRent Rent for saving in the database
     */
    void saveRent(Rent theRent);

}
