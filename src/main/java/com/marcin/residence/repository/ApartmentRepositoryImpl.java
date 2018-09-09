package com.marcin.residence.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.entity.OwnerMailingAddress;

@Repository
public class ApartmentRepositoryImpl implements ApartmentRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Apartment> getApartments(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Apartment> apartments = currentSession.createQuery(
				"SELECT a FROM Apartment a "
				/*+ "JOIN FETCH a.owner.ownerMailingAddress "*/
				+ "where a.owner.id=:id ", Apartment.class)
				.setParameter("id", theId)
				.getResultList();	
/*		OwnerMailingAddress temp = currentSession.createQuery(
				"SELECT o FROM OwnerMailingAddress o "
				+ "where o.owner.id=:id ", OwnerMailingAddress.class)
				.setParameter("id", theId)
				.getSingleResult();		*/
		return apartments;
	}

	@Override
	public Apartment getApartment(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Apartment theApartment = currentSession.createQuery(
				"SELECT a FROM Apartment a "
				+ "JOIN FETCH a.apartmentAddress "
				+ "where a.id=:id", Apartment.class)
				.setParameter("id", theId)
				.getSingleResult();
		return theApartment;
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
