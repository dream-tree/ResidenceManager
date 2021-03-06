package com.marcin.residence.repository;

import com.marcin.residence.entity.Rates;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding and updating the rates for utilities.
 *
 * @author dream-tree
  * @version 5.00, September-December 2018
 */
public interface RatesRepository {

    /**
     * Gets rates for utilities from the database.
     *
     * @return Rates object containing all fixed rates for utilities
     */
    Rates getRates();

    /**
     * Saves new rates for utilities in the database.
     *
     * @param theRates Rates object containing new rates for utilities
     */
    void saveRates(Rates theRates);
}
