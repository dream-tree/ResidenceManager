package com.marcin.residence.repository;

import com.marcin.residence.entity.Rates;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding and updating the rates for utilities.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface RatesRepository {

	/**
	 * Retrieves rates for utilities from the database.
	 * 
	 * @return Rates object containing fixed rates for utilities
	 */	
	public Rates getRates();
	
	/**
	 * Saves new rates for utilities in the database.
	 * 
	 * @param theRates Rates object containing new rates for utilities
	 */	
	public void saveRates(Rates theRates);
}
