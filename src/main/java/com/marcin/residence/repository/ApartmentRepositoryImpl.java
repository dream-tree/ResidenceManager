package com.marcin.residence.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing, adding, updating and deleting an apartment (or apartments)
 * as well as adding or updating the address of the apartment.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Repository
public class ApartmentRepositoryImpl implements ApartmentRepository {

	@Autowired
	private SessionFactory sessionFactory;

	// takes single Apartment (and its ApartmentAddress) by the Apartment id
	@Override
	public Apartment getSingleApartment(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Apartment theApartment = currentSession.createQuery(
				"SELECT a FROM Apartment a "
				+ "JOIN FETCH a.apartmentAddress "
				+ "where a.id=:id", Apartment.class)
				.setParameter("id", theId)
				.getSingleResult();
		return theApartment;
	}
	
	// takes all Apartment belonging to a given Owner (by the Owner id)
	@Override
	public List<Apartment> getOwnerApartments(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Apartment> apartments = currentSession.createQuery(
				"SELECT a FROM Apartment a "
				+ "where a.owner.id=:id ", Apartment.class)
				.setParameter("id", theId)
				.getResultList();	
		return apartments;
	}

	// takes all Apartment from the database
	@Override
	public List<Apartment> getAllApartments() {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Apartment> apartments = currentSession.createQuery(
				"FROM Apartment", Apartment.class)
				.getResultList();
		return apartments;
	}

	@Override
	public void saveApartment(Apartment theApartment) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theApartment);	
	}

	@Override
	public void deleteApartment(int theApartmentId) {
		Session currentSession = sessionFactory.getCurrentSession();		
		Apartment theApartment = currentSession.get(Apartment.class, theApartmentId);
		currentSession.delete(theApartment);
	}

	@Override
	public void saveApartmentAddress(ApartmentAddress theApartmentAddress) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theApartmentAddress);
	}
}
