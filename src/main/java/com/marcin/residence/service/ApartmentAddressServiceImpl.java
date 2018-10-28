package com.marcin.residence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.repository.ApartmentAddressRepository;

/**
 * Provides the implementation for accessing, adding and updating
 * the ApartmentAddress.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class ApartmentAddressServiceImpl implements ApartmentAddressService {

    @Autowired
    private ApartmentAddressRepository repository;

    /**
     * Gets an ApartmentAddress from the database based on the Apartment id.
     *
     * @param theApartmentId database id of an Apartment
     * @return an address of an Apartment
     */
    @Override
    @Transactional
    public ApartmentAddress getApartmentAddress(int theId) {
        return repository.getApartmentAddress(theId);
    }

    /**
     * Saves or updates an ApartmentAddress in the database.
     *
     * @param theApartmentAddress an address of a given Apartment
     *      to be saved or updated in the database
     */
    @Override
    @Transactional
    public void saveApartmentAddress(ApartmentAddress theApartmentAddress) {
        repository.saveApartmentAddress(theApartmentAddress);
    }
}
