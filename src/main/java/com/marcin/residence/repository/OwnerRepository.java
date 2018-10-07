package com.marcin.residence.repository;

import java.util.List;

import com.marcin.residence.entity.Owner;
import com.marcin.residence.entity.OwnerMailingAddress;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding, updating and deleting an owner (or owners)
 * as well as adding or updating its mailing address.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface OwnerRepository {

	/**
	 * Retrieves a single Owner from the database based on the Owner id.
	 * 
	 * @param theId database id of an Owner
	 * @return an Owner with the given id
	 */	
	public Owner getOwner(int theId);
	
	/**
	 * Saves a new Owner in the database.
	 * 
	 * @param theOwner a new Owner to be saved in the database
	 */	
	public void saveOwner(Owner theOwner);	
	
	/**
	 * Deletes an Owner from the database.
	 * 
	 * @param theId database id of an Owner to be deleted
	 */	
	public void deleteOwner(int theId);
	
	/**
	 * Retrieves all Owners from the database.
	 * 
	 * @return a list of Owners retrieved from the database
	 */	
	public List<Owner> getOwners();	
	
	/**
	 * Retrieves Owners from the database based on the user input in the searching bar.
	 * 
	 * @param theSearchName string of characters typed by user in the searching bar
	 * @return a list of Owners retrieved from the database fulfilling the criteria of the user query
	 */	
	public List<Owner> searchOwners(String theSearchName);
	
	/**
	 * Saves an OwnerMailingAddress in the database.
	 * 
	 * @param theOwnerMailingAddress a new OwnerMailingAddress to be saved in the database
	 */	
	public void saveOwnerMailingAddress(OwnerMailingAddress theOwnerMailingAddress);
	
	/**
	 * Retrieves an OwnerMailingAddress from the database based on the Owner id.
	 * 
	 * @param theId database id of an Owner
	 * @return an OwnerMailingAddress belonging to the Owner of the given id
	 */	
	public OwnerMailingAddress getOwnerMailingAddress(int theId);
}
