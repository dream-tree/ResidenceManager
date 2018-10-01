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

	public Rates getRates();
	public void saveRates(Rates theRates);
}
