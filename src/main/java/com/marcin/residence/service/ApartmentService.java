package com.marcin.residence.service;

import java.util.List;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;

/**
 * Provides the service for accessing, adding, updating and deleting an apartment (or apartments)
 * as well as adding or updating the address of the apartment. 
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentService {

	public Apartment getSingleApartment(int theId);	
	public List<Apartment> getOwnerApartments(int theId);	
	public List<Apartment> getAllApartments();
	public void saveApartment(Apartment theApartment);
	public void deleteApartment(int theApartmentId);
	public void saveApartmentAddress(ApartmentAddress theApartmentAddress);
	
}
