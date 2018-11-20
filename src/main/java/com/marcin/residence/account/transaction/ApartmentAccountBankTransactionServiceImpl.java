package com.marcin.residence.account.transaction;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides the implementation for accessing bank account transactions for
 * a given apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class ApartmentAccountBankTransactionServiceImpl implements
        ApartmentAccountBankTransactionService {

    @Autowired
    private ApartmentAccountBankTransactionRepository bankAccountTransactionsRepository;

    /**
     * Gets a list of an apartment account bank transactions.
     *
     * @param theApartmentId database id of an apartment
     * @return list of apartment account bank transactions
     */
    @Override
    @Transactional
    public List<ApartmentAccountBankTransaction> getTransactions(int theApartmentId) {
        return bankAccountTransactionsRepository.getTransactions(theApartmentId);
    }

}
