package com.marcin.residence.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcin.residence.entity.Rates;
import com.marcin.residence.repository.RatesRepository;

/**
 * Provides the implementation for accessing, adding and updating the rates for utilities. 
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class RatesServiceImpl implements RatesService {

	@Autowired
	private RatesRepository ratesRepository;
	
	@Override
	@Transactional
	public Rates getRates() {
		return ratesRepository.getRates();
	}
	
	@Override
	@Transactional
	public void saveRates(Rates theRates) {
		ratesRepository.saveRates(theRates);
	}
}
