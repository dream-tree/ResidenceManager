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

	/**
	 * Retrieves a single Apartment and its ApartmentAddress from the database 
	 * based on the Apartment id.
	 * 
	 * @param theId database id of an Apartment
	 * @return an Apartment with the given id
	 */	
	public Apartment getSingleApartment(int theId);	
	
	/**
	 * Retrieves all Apartments belonging to a given Owner based on the Owner id.
	 * 
	 * @param theId database id of an Owner
	 * @return all Apartments of a given Owner
	 */	
	public List<Apartment> getOwnerApartments(int theId);
	
	/**
	 * Retrieves all Apartments from the database.
	 * 
	 * @return all Apartments in the database
	 */	
	public List<Apartment> getAllApartments();
	
	/**
	 * Saves a new Apartment or updates an existing one in the database.
	 * 
	 * @param theApartment an Apartment to be saved or updated
	 */	
	public void saveApartment(Apartment theApartment);
	
	/**
	 * Deletes an Apartment of a given id from the database.
	 * 
	 * @param theApartmentId database id of an Apartment
	 */	
	public void deleteApartment(int theApartmentId);
	
	/**
	 * Saves or updates an ApartmentAddres of a given Apartment in the database.
	 * 
	 * @param theApartmentAddress an ApartmentAddres to be saved or updated
	 */	
	public void saveApartmentAddress(ApartmentAddress theApartmentAddress);
	
}
