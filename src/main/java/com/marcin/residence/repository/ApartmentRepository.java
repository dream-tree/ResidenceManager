package com.marcin.residence.repository;

import java.util.List;

import com.marcin.residence.account.balance.ApartmentAccountBalance;
import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.entity.Rent;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding, updating and deleting an Apartment (or Apartment-s).
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentRepository {

    /**
     * Gets a single Apartment from the database based on the Apartment id.
     *
     * @param theApartmentId database id of an Apartment
     * @return an Apartment with the given id
     */
    Apartment getSingleApartment(int theApartmentId);

    /**
     * Gets all Apartments belonging to a given Owner based on the Owner id.
     *
     * @param theOwnerId database id of an Owner
     * @return all Apartments of a given Owner
     */
    List<Apartment> getOwnerApartments(int theOwnerId);

    /**
     * Gets all Apartments from the database.
     *
     * @return all Apartments in the database
     */
    List<Apartment> getAllApartments();

    /**
     * Updates an existing apartment in the database.
     *
     * @param theApartment an apartment to be updated
     */
    public void updateApartment(Apartment theApartment);
    
    /**
     * Saves a new apartment in the database altogether with the predefined rent,
     * apartment address and apartment account balance.
     *
     * @param theApartment a new apartment to be saved 
     * @param theRent a predefined ("zero" values) apartment rent to be saved 
     * @param theApartmentAddress a predefined apartment address to be saved 
     * @param theBalance predefined ("zero" values) apartment account balance
     *          to be saved 
     */  
    public void saveApartment(Apartment theApartment, Rent theRent,
            ApartmentAddress theApartmentAddress, ApartmentAccountBalance theBalance);
    
    /**
     * Deletes an Apartment of a given id from the database.
     *
     * @param theApartmentId database id of an Apartment
     */
    void deleteApartment(int theApartmentId);

}
