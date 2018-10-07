package com.marcin.residence.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Owner;
import com.marcin.residence.entity.OwnerMailingAddress;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing, adding, updating and deleting an owner (or owners)
 * as well as adding or updating its mailing address.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Repository
public class OwnerRepositoryImpl implements OwnerRepository {

	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public Owner getOwner(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Owner theOwner = currentSession.createQuery("SELECT o from Owner o "
				+ "JOIN FETCH o.ownerMailingAddress "
				+ "WHERE o.id=:id", Owner.class)
				.setParameter("id", theId)
				.getSingleResult();
		return theOwner;		
	}

	@Override
	public void saveOwner(Owner theOwner) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theOwner);		
	}

	@Override
	public void deleteOwner(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.createQuery("DELETE from Owner WHERE id=:ownerId")
					.setParameter("ownerId", theId)
					.executeUpdate();		
	}

	@Override
	public List<Owner> getOwners() {	
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Owner> theQuery = currentSession.createQuery("from Owner ORDER BY lastName", Owner.class);
		List<Owner> owners = theQuery.getResultList();		
		return owners;
	}
	
	 @Override
	 public List<Owner> searchOwners(String theSearchName) {
		 Session currentSession = sessionFactory.getCurrentSession();
		 Query theQuery = null;	
		 if (theSearchName != null && theSearchName.trim().length() > 0) {	
			 // search for firstName or lastName, case insensitive
			 theQuery = currentSession.createQuery("FROM Owner "
					 	+ "WHERE lower(firstName) LIKE :theName "
					 	+ "OR lower(lastName) LIKE :theName "
					 	+ "OR id LIKE :theName",
					 	Owner.class);
			 theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		 } else {
			 // if theSearchName is empty, get all Owners
			 theQuery = currentSession.createQuery("from Owner ORDER BY lastName", Owner.class);
		 }	
		 List<Owner> owners = theQuery.getResultList();
		 return owners;
	 }

	@Override
	public void saveOwnerMailingAddress(OwnerMailingAddress theOwnerMailingAddress) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theOwnerMailingAddress);
	}

	@Override
	public OwnerMailingAddress getOwnerMailingAddress(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		OwnerMailingAddress ownerMailingAddress = currentSession.createQuery(
				"SELECT o FROM OwnerMailingAddress o "
				+ "WHERE o.owner.id=:id", OwnerMailingAddress.class)
				.setParameter("id", theId)
				.getSingleResult();
		return ownerMailingAddress;
	}
}
