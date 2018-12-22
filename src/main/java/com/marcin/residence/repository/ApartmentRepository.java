package com.marcin.residence.repository;

import java.util.List;

import com.marcin.residence.account.balance.ApartmentAccountBalance;
import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.entity.Rent;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding, updating and deleting an apartment (or apartments).
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
public interface ApartmentRepository {

    /**
     * Gets a single apartment from the database based on the apartment id.
     *
     * @param theApartmentId database id of an apartment
     * @return an apartment with the given id
     */
    Apartment getSingleApartment(int theApartmentId);

    /**
     * Gets all apartments belonging to a given owner based on the owner id.
     *
     * @param theOwnerId database id of an owner
     * @return all apartments of a given owner
     */
    List<Apartment> getOwnerApartments(int theOwnerId);

    /**
     * Gets all apartments from the database.
     *
     * @return all apartments in the database
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
     * Deletes an apartment of a given id from the database.
     *
     * @param theApartmentId database id of an apartment
     */
    void deleteApartment(int theApartmentId);

}
