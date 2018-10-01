package com.marcin.residence.service;

import java.util.List;

import javax.validation.Valid;

import com.marcin.residence.entity.Owner;
import com.marcin.residence.entity.OwnerMailingAddress;

/**
 * Provides the service for accessing, adding, updating and deleting an owner (or owners)
 * as well as adding or updating its mailing address. 
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface OwnerService {
	
	public Owner getOwner(int theId);	
	public void saveOwner(Owner theOwner);
	public void deleteOwner(int theId);
	public List<Owner> getOwners();	
	public List<Owner> searchOwners(String theSearchName);
	public void saveOwnerMailingAddress(@Valid OwnerMailingAddress ownerMailingAddress);
	public OwnerMailingAddress getOwnerMailingAddress(int theId);
	
}
