package com.marcin.residence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.repository.ApartmentRepository;

@Service
public class ApartmentServiceImpl implements ApartmentService {

	@Autowired
	private ApartmentRepository apartmentRepository;
	
	@Override
	@Transactional
	public List<Apartment> getApartments(int theId) {
		return apartmentRepository.getApartments(theId);
	}

	@Override
	@Transactional
	public Apartment getApartment(int theId) {
		return apartmentRepository.getApartment(theId);
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
