package com.marcin.residence.repository;

import java.util.List;

import com.marcin.residence.entity.Apartment;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for updating the rent for a given apartment (or for the all available apartments).
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface RentRepository {

	public void saveRent(Apartment theApartment);
	public void saveAllRents(List<Apartment> theApartments);
}
