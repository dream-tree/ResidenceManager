package com.marcin.residence.service;

/**
 * Provides the service for calculating and updating the rents for all available
 * apartments in the database.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface RentService {

    /**
     * Calculates new rents for all apartments in the database.
     */
    void calculateAllRents();

}
