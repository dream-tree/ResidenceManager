package com.marcin.residence.account.balance;

import java.util.List;

import com.marcin.residence.entity.Rent;

/**
 * Provides the service for accessing and updating apartment account balance
 * for a given apartment.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentAccountBalanceService {

    /**
     * Gets an apartment account balance for a given apartment.
     *
     * @param theApartmentId database id of an apartment
     * @return apartment account balance for a given apartment
     */
    ApartmentAccountBalance getApartmentAccountBalance(int theApartmentId);

    /**
     * Updates an apartment account balance for all apartments.
     *
     * @param rentList list of all Rent objects in the database
     */
    void updateApartmentAccountBalance(List<Rent> rentList);

}
