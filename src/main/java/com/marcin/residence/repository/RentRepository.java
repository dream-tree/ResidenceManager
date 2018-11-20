package com.marcin.residence.repository;

import java.util.List;

import com.marcin.residence.entity.Rent;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding and updating (calculating) rent for a given apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface RentRepository {

    /**
     * Gets a rent for given apartment.
     *
     * @param apartmentId database id of an Apartment
     * @return rent for a given apartment
     */
    Rent getRent(int apartmentId);

    /**
     * Saves a rent for given apartment in the database.
     *
     * @param theRent rent for saving in the database
     */
    void saveRent(Rent theRent);

    /**
     * Gets all rents for all apartments in order to calculate current
     * apartments liabilities.
     *
     * @return list of Rent objects
     */
    List<Rent> getAllRents();

}
