package com.marcin.residence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.residence.entity.Owner;
import com.marcin.residence.repository.OwnerRepository;

/**
 * Provides the implementation for accessing, adding, updating, deleting
 * and searching an Owner (or Owner-s).
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    /**
     * Gets an Owner from the database based on the Owner id.
     *
     * @param theOwnerId database id of an Owner
     * @return an Owner retrieved from the database
     */
    @Override
    @Transactional
    public Owner getOwner(int theOwnerId) {
        return ownerRepository.getOwner(theOwnerId);
    }

    /**
     * Saves or updates an Owner in the database.
     *
     * @param theOwner an Owner to be saved or updated in the database
     */
    @Override
    @Transactional
    public void saveOwner(Owner theOwner) {
        ownerRepository.saveOwner(theOwner);
    }

    /**
     * Deletes an Owner from the database based on the Owner id.
     *
     * @param theOwnerId id of an Owner to be deleted from the database
     */
    @Override
    @Transactional
    public void deleteOwner(int theOwnerId) {
        ownerRepository.deleteOwner(theOwnerId);
    }

    /**
     * Gets all Owner-s from the database.
     *
     * @return list of Owner-s retrieved from the database
     */
    @Override
    @Transactional
    public List<Owner> getOwners() {
        return ownerRepository.getOwners();
    }

    /**
     * Searches Owners in the database based on the user input typed
     * in the searching bar.
     *
     * @param theSearchName string of characters typed by user
     *      in the searching bar
     * @return a list of Owners retrieved from the database, fulfilling
     *      the criteria of the user query
     */
    @Override
    @Transactional
    public List<Owner> searchOwners(String theSearchName) {
        return ownerRepository.searchOwners(theSearchName);
    }
}