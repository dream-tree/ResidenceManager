package com.marcin.residence.account.liability;

import java.util.List;

import com.marcin.residence.entity.Rent;

/**
 * Provides the service for accessing, adding and updating liabilities for
 * a given apartment account.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentAccountLiabilityService {

    /**
     * Gets a list of liability calculations for a single apartment.
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
