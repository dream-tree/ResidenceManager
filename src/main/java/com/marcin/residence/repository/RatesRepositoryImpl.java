package com.marcin.residence.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Rates;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing, adding and updating the rates for utilities.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Repository
public class RatesRepositoryImpl implements RatesRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Rates getRates() {
		Session currentSession = sessionFactory.getCurrentSession();
		Rates rates = currentSession.get(Rates.class, 1);		
		return rates;
	}
		
	@Override
	public void saveRates(Rates theRates) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theRates);
	}
}