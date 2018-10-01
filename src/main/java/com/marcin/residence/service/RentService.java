package com.marcin.residence.service;

import java.util.List;

import com.marcin.residence.entity.Apartment;

/**
 * Provides the service for calculating and updating the rent for a given apartment 
 * (or for the all available apartments). 
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface RentService {

	public void calculateSingleRent();
	public void calculateAllRents();
	public void saveSingleRent(List<Apartment> theApartments);
	public void saveAllRents(List<Apartment> theApartments);
	
}
