package com.marcin.residence.service;

import com.marcin.residence.entity.Rates;

/**
 * Provides the service for accessing, adding and updating the rates
 * for utilities.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
public interface RatesService {

    /**
     * Gets the current rates for utilities from the database.
     *
     * @return Rates object containing all current rates for utilities
     */
    Rates getRates();

    /**
     * Saves or updates new rates for utilities in the database.
     *
     * @param theRates Rates object containing new rates for utilities
     *      to be saved or updated in the database
     */
    void saveRates(Rates theRates);

}
