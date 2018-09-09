package com.marcin.residence.repository;

import java.util.List;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;

public interface ApartmentRepository {

	public List<Apartment> getApartments(int theId);

	public Apartment getApartment(int theId);

	public void saveApartment(Apartment theApartment);

	public void deleteApartment(int theApartmentId);

	public void saveApartmentAddress(ApartmentAddress theApartmentAddress);

}
