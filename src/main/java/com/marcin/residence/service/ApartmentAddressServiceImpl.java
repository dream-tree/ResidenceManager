package com.marcin.residence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.repository.ApartmentAddressRepository;

/**
 * Provides the implementation for accessing, adding and updating
 * the apartment address.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Service
public class ApartmentAddressServiceImpl implements ApartmentAddressService {

    @Autowired
    private ApartmentAddressRepository repository;

    /**
     * Gets an apartment address from the database based on the id of an apartment.
     *
     * @param theApartmentId database id of an apartment
     * @return an address of an apartment
     */
    @Override
    @Transactional
    public ApartmentAddress getApartmentAddress(int theApartmentId) {
        return repository.getApartmentAddress(theApartmentId);
    }

    /**
     * Saves or updates an apartment address in the database.
     *
     * @param theApartmentAddress an address of a given apartment
     *      to be saved or updated in the database
     */
    @Override
    @Transactional
    public void saveApartmentAddress(ApartmentAddress theApartmentAddress) {
        repository.saveApartmentAddress(theApartmentAddress);
    }
}
