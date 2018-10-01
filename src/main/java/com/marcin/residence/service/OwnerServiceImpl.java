package com.marcin.residence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.residence.entity.Owner;
import com.marcin.residence.entity.OwnerMailingAddress;
import com.marcin.residence.repository.OwnerRepository;

/**
 * Provides the implementation for accessing, adding, updating and deleting an owner (or owners)
 * as well as adding or updating its mailing address. 
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class OwnerServiceImpl implements OwnerService {
	
	@Autowired
	private OwnerRepository ownerRepository;
			
	@Override
	@Transactional
	public Owner getOwner(int theId) {		
		return ownerRepository.getOwner(theId);
	}

	@Override
	@Transactional
	public void saveOwner(Owner theOwner) {
		ownerRepository.saveOwner(theOwner);		
	}

	@Override
	@Transactional
	public void deleteOwner(int theId) {
		ownerRepository.deleteOwner(theId);	
	}

	@Override
	@Transactional
	public List<Owner> getOwners() {
		return ownerRepository.getOwners();
	}
	
	@Override
	@Transactional
	public List<Owner> searchOwners(String theSearchName) {
		return ownerRepository.searchOwners(theSearchName);
	}

	@Override
	@Transactional
	public void saveOwnerMailingAddress(OwnerMailingAddress ownerMailingAddress) {
		ownerRepository.saveOwnerMailingAddress(ownerMailingAddress);
	}

	@Override
	@Transactional
	public OwnerMailingAddress getOwnerMailingAddress(int theId) {
		return ownerRepository.getOwnerMailingAddress(theId);		
	}
}
