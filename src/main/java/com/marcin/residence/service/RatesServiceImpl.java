package com.marcin.residence.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcin.residence.entity.Rates;
import com.marcin.residence.repository.RatesRepository;

/**
 * Provides the implementation for accessing, adding and updating the rates
 * for utilities.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Service
public class RatesServiceImpl implements RatesService {

    @Autowired
    private RatesRepository ratesRepository;

    /**
     * Gets the current rates for utilities from the database.
     *
     * @return Rates object containing all current rates for utilities
     */
    @Override
    @Transactional
    public Rates getRates() {
        return ratesRepository.getRates();
    }

    /**
     * Saves or updates new rates for utilities in the database.
     *
     * @param theRates Rates object containing new rates for utilities
     *      to be saved or updated in the database
     */
    @Override
    @Transactional
    public void saveRates(Rates theRates) {
        ratesRepository.saveRates(theRates);
    }
}