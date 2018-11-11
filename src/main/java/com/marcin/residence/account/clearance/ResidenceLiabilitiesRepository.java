package com.marcin.residence.account.clearance;

import java.util.List;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing liabilities for a given Apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ResidenceLiabilitiesRepository {

    /**
     * Gets a list of liabilities for a given Apartment.
     *
     * @param theApartmentId database id of an Apartment
     * @return list of an Apartment liabilities
     */
    List<ResidenceLiabilities> getLiabilities(int theApartmentId);

}
