package com.marcin.residence.account.clearance;

import java.util.List;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing bank account transactions for a given Apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface BankAccountTransactionsRepository {

    /**
     * Gets a list of bank account transactions for a given Apartment.
     *
     * @param theApartmentId database id of an Apartment
     * @return list of bank account transactions
     */
    List<BankAccountTransactions> getTransactions(int theApartmentId);

}
