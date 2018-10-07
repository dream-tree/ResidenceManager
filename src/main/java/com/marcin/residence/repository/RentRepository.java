package com.marcin.residence.repository;

import com.marcin.residence.entity.Rent;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for updating the rent for a given apartment (or for the all available apartments).
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface RentRepository {

	/**
	 * Saves an individual Rent for a given Apartment in the database.
	 * 
	 * @param theRent Rent for saving in the database
	 */	
	public void saveRent(Rent theRent);
	
}
