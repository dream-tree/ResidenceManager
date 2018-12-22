package com.marcin.residence.account.liability;

import java.util.List;

import com.marcin.residence.entity.Rent;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing, adding and updating liabilities for a given apartment account.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
public interface ApartmentAccountLiabilityRepository {

    /**
     * Gets a list of all liability calculations for a single apartment.
     *
     * @param theApartmentId database id of an apartment
     * @return list of an apartment account liabilities
     */
    List<ApartmentAccountLiability> getLiabilities(int theApartmentId);

    /**
     * Adds new liability value for an apartment. Operation is executed for all
     * apartments available in the database (bulk operation).
     *
     * @param rentList list of rents for all apartments
     */
    void addAllLiabilities(List<Rent> rentList);

}
