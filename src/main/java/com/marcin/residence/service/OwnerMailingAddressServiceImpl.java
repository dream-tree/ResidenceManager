package com.marcin.residence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.residence.entity.OwnerMailingAddress;
import com.marcin.residence.repository.OwnerMailingAddressRepository;

/**
 * Provides the implementation for accessing, adding and updating
 * the owner mailing address.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Service
public class OwnerMailingAddressServiceImpl implements OwnerMailingAddressService {

    @Autowired
    private OwnerMailingAddressRepository repository;

    /**
     * Gets an owner mailing address from the database based on the owner id.
     *
     * @param theOwnerId database id of an owner
     * @return mailing address of an owner
     */
    @Override
    @Transactional
    public OwnerMailingAddress getOwnerMailingAddress(int theOwnerId) {
        return repository.getOwnerMailingAddress(theOwnerId);
    }

    /**
     * Saves or updates an owner mailing address in the database.
     *
     * @param theOwnerMailingAddress a mailing address of a given owner
     *      to be saved or updated in the database
     */
    @Override
    @Transactional
    public void saveOwnerMailingAddress(OwnerMailingAddress theOwnerMailingAddress) {
        repository.saveOwnerMailingAddress(theOwnerMailingAddress);
    }
}
