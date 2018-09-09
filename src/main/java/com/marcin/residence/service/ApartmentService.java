package com.marcin.residence.service;

import java.util.List;

import javax.validation.Valid;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;

public interface ApartmentService {

	public List<Apartment> getApartments(int theId);

	public Apartment getApartment(int theId);

	public void saveApartment(Apartment theApartment);

	public void deleteApartment(int theApartmentId);

	public void saveApartmentAddress(ApartmentAddress theApartmentAddress);

}
