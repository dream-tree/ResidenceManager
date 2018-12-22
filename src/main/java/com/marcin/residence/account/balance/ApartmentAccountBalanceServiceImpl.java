package com.marcin.residence.account.balance;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcin.residence.account.transaction.ApartmentAccountBankTransaction;
import com.marcin.residence.entity.Rent;

/**
 * Provides the implementation for accessing and updating apartment account
 * balance for a given apartment.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Service
public class ApartmentAccountBalanceServiceImpl implements ApartmentAccountBalanceService {

    @Autowired
    private ApartmentAccountBalanceRepository apartmentAccountBalanceRepository;

    /**
     * Gets an apartment account balance for a given apartment.
     *
     * @param theApartmentId database id of an apartment
     * @return apartment account balance for a given apartment
     */
    @Override
    @Transactional
    public ApartmentAccountBalance getApartmentAccountBalance(int theApartmentId) {
        return apartmentAccountBalanceRepository.getApartmentAccountBalance(theApartmentId);
    }

    /**
     * Updates (increases) an apartment account balance.
     * The action involves every apartment in the database whose liabilities
     * have to be increased due to monthly rent calculation (bulk operation).
     *
     * @param rentList list of rents for updating account balance for every
     * involved apartment
     */
    @Override
    @Transactional
    public void increaseApartmentAccountBalance(List<Rent> rentList) {
        apartmentAccountBalanceRepository.increaseApartmentAccountBalance(rentList);
    }

    /**
     * Updates (decreases) an apartment account balance.
     * The action involves every apartment in the database whose liabilities
     * have to be decreased due to payment made by the owner into a bank account
     * related to the corresponding apartment account (bulk operation).
     *
     * @param transactionList list of bank transactions for updating account
     * balance for every involved apartment
     */
    @Override
    @Transactional
    public void decreaseApartmentAccountBalance(
            List<ApartmentAccountBankTransaction> transactionList) {
        apartmentAccountBalanceRepository.decreaseApartmentAccountBalance(transactionList);
    }
}
