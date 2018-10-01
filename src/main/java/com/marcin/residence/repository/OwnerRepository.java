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

	public Owner getOwner(int theId);
	public void saveOwner(Owner theOwner);	
	public void deleteOwner(int theId);
	public List<Owner> getOwners();	
	public List<Owner> searchOwners(String theSearchName);
	public void saveOwnerMailingAddress(OwnerMailingAddress ownerMailingAddress);
	public OwnerMailingAddress getOwnerMailingAddress(int theId);
}
