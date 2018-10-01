package com.marcin.residence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.repository.ApartmentRepository;

/**
 * Provides the implementation for accessing, adding, updating and deleting an apartment (or apartments)
 * as well as adding or updating the address of the apartment. 
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class ApartmentServiceImpl implements ApartmentService {

	@Autowired
	private ApartmentRepository apartmentRepository;
	
	@Override
	@Transactional
	public Apartment getSingleApartment(int theId) {
		return apartmentRepository.getSingleApartment(theId);
	}
	
	@Override
	@Transactional
	public List<Apartment> getOwnerApartments(int theId) {
		return apartmentRepository.getOwnerApartments(theId);
	}

	@Override
	@Transactional
	public List<Apartment> getAllApartments() {
		return apartmentRepository.getAllApartments();
	}


	@Override
	@Transactional
	public void saveApartment(Apartment theApartment) {
		apartmentRepository.saveApartment(theApartment);
	}

	@Override
	@Transactional
	public void deleteApartment(int theApartmentId) {
		apartmentRepository.deleteApartment(theApartmentId);
		
	}

	@Override
	@Transactional
	public void saveApartmentAddress(ApartmentAddress theApartmentAddress) {
		apartmentRepository.saveApartmentAddress(theApartmentAddress);
	}

}
