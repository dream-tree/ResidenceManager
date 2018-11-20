package com.marcin.residence.account.balance;

import java.util.List;

import com.marcin.residence.entity.Rent;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing and updating apartment account balance for a given apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentAccountBalanceRepository {

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
