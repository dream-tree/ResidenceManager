package com.marcin.residence.account.clearance;

import java.util.List;

/**
 * Provides the service for accessing bank account transactions for
 * a given Apartment.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface BankAccountTransactionsService {

    /**
     * Gets a list of bank account transactions for a given Apartment.
     *
     * @param theApartmentId database id of an Apartment
     * @return list of bank account transactions
     */
    List<BankAccountTransactions> getTransactions(int theApartmentId);
}
