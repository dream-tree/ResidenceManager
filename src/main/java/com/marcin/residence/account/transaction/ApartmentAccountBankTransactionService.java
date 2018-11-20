package com.marcin.residence.account.transaction;

import java.util.List;

/**
 * Provides the service for accessing bank account transactions for a given
 * apartment.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentAccountBankTransactionService {

    /**
     * Gets a list of an apartment account bank transactions.
     *
     * @param theApartmentId database id of an apartment
     * @return list of apartment account bank transactions
     */
    List<ApartmentAccountBankTransaction> getTransactions(int theApartmentId);
}
