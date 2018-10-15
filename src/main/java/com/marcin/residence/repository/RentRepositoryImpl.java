package com.marcin.residence.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Rent;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for saving the rent for a given apartment (or for the all available apartments).
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Repository
public class RentRepositoryImpl implements RentRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveRent(Rent theRent) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theRent);			
	}
}