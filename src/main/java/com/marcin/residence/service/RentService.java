package com.marcin.residence.service;

import java.util.List;

import com.marcin.residence.entity.Rent;

/**
 * Provides the service for accessing, adding and updating (calculating) rent
 * for an apartment.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface RentService {

    /**
     * Gets a current rent for given apartment.
     * @param theApartmentId database id of an apartment
     * @return a current rent for given apartment
     */
    Rent getRent(int theApartmentId);

    /**
     * Calculates rents for all apartments in the database after an update
     * on rates for utilities is made.
     */
    void calculateAllRents();

    /**
     * Gets all rents for all apartments in order to calculate current liability
     * values for apartments.
     *
     * @return list of rents for all apartments in the database
     */
    List<Rent> getAllRents();
}
