package com.marcin.residence.service;

import com.marcin.residence.entity.Rates;

/**
 * Provides the service for accessing, adding and updating the rates for utilities. 
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface RatesService {
	
	public Rates getRates();
	public void saveRates(Rates theRates);
}
