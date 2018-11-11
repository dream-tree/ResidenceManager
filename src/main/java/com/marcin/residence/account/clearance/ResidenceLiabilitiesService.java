package com.marcin.residence.account.clearance;

import java.util.List;

/**
 * Provides the service for accessing the Apartment liabilities.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ResidenceLiabilitiesService {

    /**
     * Gets a list of liabilities for a given Apartment.
     *
     * @param theApartmentId database id of an Apartment
     * @return list of an Apartment liabilities
     */
    List<ResidenceLiabilities> getLiabilities(int theApartmentId);
}
