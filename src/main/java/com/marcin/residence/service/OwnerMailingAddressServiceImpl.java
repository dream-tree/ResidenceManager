package com.marcin.residence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.residence.entity.OwnerMailingAddress;
import com.marcin.residence.repository.OwnerMailingAddressRepository;

/**
 * Provides the implementation for accessing, adding and updating
 * the OwnerMailingAddress.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class OwnerMailingAddressServiceImpl implements OwnerMailingAddressService {

    @Autowired
    private OwnerMailingAddressRepository repository;

    /**
     * Gets an OwnerMailingAddress from the database based on the Owner id.
     *
     * @param theOwnerId database id of an Owner
     * @return mailing address of an Owner
     */
    @Override
    @Transactional
    public OwnerMailingAddress getOwnerMailingAddress(int theOwnerId) {
        return repository.getOwnerMailingAddress(theOwnerId);
    }

    /**
     * Saves or updates an OwnerMailingAddress in the database.
     *
     * @param theOwnerMailingAddress a mailing address of a given Owner
     *      to be saved or updated in the database
     */
    @Override
    @Transactional
    public void saveOwnerMailingAddress(OwnerMailingAddress theOwnerMailingAddress) {
        repository.saveOwnerMailingAddress(theOwnerMailingAddress);
    }
}
