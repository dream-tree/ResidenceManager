package com.marcin.residence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.entity.Rent;
import com.marcin.residence.repository.ApartmentAddressRepository;
import com.marcin.residence.repository.ApartmentRepository;
import com.marcin.residence.repository.RentRepository;

/**
 * Provides the implementation for accessing, adding, updating and deleting
 * an Apartment (or Apartment-s).
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private ApartmentAddressRepository apartmentAddressRepository;

    /**
     * Gets a single Apartment from the database based on the Apartment id.
     *
     * @param theApartmentId database id of an Apartment
     * @return an Apartment retrieved from the database
     */
    @Override
    @Transactional
    public Apartment getSingleApartment(int theApartmentId) {
        return apartmentRepository.getSingleApartment(theApartmentId);
    }

    /**
     * Gets all Apartment-s of a given Owner from the database
     * based on the Owner id.
     *
     * @param theOwnerId database id of an Owner
     * @return list of Apartment-s retrieved from the database
     */
    @Override
    @Transactional
    public List<Apartment> getOwnerApartments(int theOwnerId) {
        List<Apartment> theApartments = apartmentRepository.getOwnerApartments(theOwnerId);
        for (Apartment apartment : theApartments) {
            int theApartmentId = apartment.getId();
            ApartmentAddress apartmentAddress =
                    apartmentAddressRepository.getApartmentAddress(theApartmentId);
            apartment.setApartmentAddress(apartmentAddress);
            Rent rent = rentRepository.getRent(theApartmentId);
            apartment.setRent(rent);
        }
        return theApartments;
    }

    /**
     * Gets all Apartment-s from the database.
     *
     * @return list of all Apartment-s retrieved from the database
     */
    @Override
    @Transactional
    public List<Apartment> getAllApartments() {
        return apartmentRepository.getAllApartments();
    }

    /**
     * Saves or updates a single Apartment in the database.
     *
     * @param theApartment an apartment to be saved or updated in the database
     */
    @Override
    @Transactional
    public void saveApartment(Apartment theApartment) {
        apartmentRepository.saveApartment(theApartment);
    }

    /**
     * Deletes a single Apartment from the database based on the Apartment id.
     *
     * @param theApartmentId id of an Apartment to be deleted from the database
     */
    @Override
    @Transactional
    public void deleteApartment(int theApartmentId) {
        apartmentRepository.deleteApartment(theApartmentId);
    }
}
