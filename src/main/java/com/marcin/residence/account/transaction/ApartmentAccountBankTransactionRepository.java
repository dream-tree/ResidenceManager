package com.marcin.residence.account.transaction;

import java.util.List;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing bank account transactions for a given apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
public interface ApartmentAccountBankTransactionRepository {

    /**
     * Gets a list of an apartment account bank transactions.
     *
     * @param theApartmentId database id of an apartment
     * @return list of apartment account bank transactions
     */
    List<ApartmentAccountBankTransaction> getTransactions(int theApartmentId);

}
