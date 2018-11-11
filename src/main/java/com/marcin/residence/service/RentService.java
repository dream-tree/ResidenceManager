package com.marcin.residence.service;

import com.marcin.residence.entity.Rent;

/**
 * Provides the service for calculating, adding and updating the rents for all
 * available apartments in the database.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface RentService {

    /**
     * Gets a current Rent for given Apartment.
     * @param theApartmentId database id of an Apartment
     * @return a current Rent for given Apartment
     */
    Rent getRent(int theApartmentId);
    
    /**
     * Calculates rents for all apartments in the database after an update
     * on rates for utilities is made.
     */
    void calculateAllRents();

}
