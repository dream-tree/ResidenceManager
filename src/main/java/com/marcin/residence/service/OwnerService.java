package com.marcin.residence.service;

import java.util.List;

import javax.validation.Valid;

import com.marcin.residence.entity.Owner;
import com.marcin.residence.entity.OwnerMailingAddress;

public interface OwnerService {
	
	public Owner getOwner(int theId);
	
	public void saveOwner(Owner theOwner);

	public void deleteOwner(int theId);

	public List<Owner> getOwners();
	
	public List<Owner> searchOwners(String theSearchName);

	public void saveOwnerMailingAddress(@Valid OwnerMailingAddress ownerMailingAddress);

	public OwnerMailingAddress getOwnerMailingAddress(int theId);
	
}
