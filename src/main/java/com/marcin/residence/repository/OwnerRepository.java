package com.marcin.residence.repository;

import java.util.List;

import com.marcin.residence.entity.Owner;
import com.marcin.residence.entity.OwnerMailingAddress;

public interface OwnerRepository {

	public Owner getOwner(int theId);

	public void saveOwner(Owner theOwner);
	
	public void deleteOwner(int theId);

	public List<Owner> getOwners();
	
	public List<Owner> searchOwners(String theSearchName);

	public void saveOwnerMailingAddress(OwnerMailingAddress ownerMailingAddress);

	public OwnerMailingAddress getOwnerMailingAddress(int theId);
}
