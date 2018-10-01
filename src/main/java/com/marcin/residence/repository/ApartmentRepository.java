package com.marcin.residence.repository;

import java.util.List;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding, updating and deleting an apartment (or apartments)
 * as well as adding or updating the address of the apartment.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentRepository {

	public Apartment getSingleApartment(int theId);	
	public List<Apartment> getOwnerApartments(int theId);
	public List<Apartment> getAllApartments();
	public void saveApartment(Apartment theApartment);
	public void deleteApartment(int theApartmentId);
	public void saveApartmentAddress(ApartmentAddress theApartmentAddress);

}
