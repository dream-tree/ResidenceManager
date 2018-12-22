package com.marcin.residence.account.balance;

import java.util.List;

import com.marcin.residence.account.transaction.ApartmentAccountBankTransaction;
import com.marcin.residence.entity.Rent;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing and updating apartment account balance for a given apartment.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
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
     * Updates (increases) an apartment account balance.
     * The action involves every apartment in the database whose liabilities
     * have to be increased due to monthly rent calculation (bulk operation).
     *
     * @param rentList list of rents for updating account balance for every
     * involved apartment
     */
    void increaseApartmentAccountBalance(List<Rent> rentList);

    /**
     * Updates (decreases) an apartment account balance.
     * The action involves every apartment in the database whose liabilities
     * have to be decreased due to payment made by the owner into a bank account
     * related to the corresponding apartment account (bulk operation).
     *
     * @param transactionList list of bank transactions for updating account
     * balance for every involved apartment
     */
    void decreaseApartmentAccountBalance(List<ApartmentAccountBankTransaction> transactionList);
}
