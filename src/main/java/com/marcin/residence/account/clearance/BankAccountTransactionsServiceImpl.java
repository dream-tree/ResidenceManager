package com.marcin.residence.account.clearance;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides the implementation for accessing bank account transactions for
 * a given Apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class BankAccountTransactionsServiceImpl implements BankAccountTransactionsService {

    @Autowired
    private BankAccountTransactionsRepository bankAccountTransactionsRepository;

    /**
     * Gets a list of bank account transactions for a given Apartment.
     *
     * @param theApartmentId database id of an Apartment
     * @return list of bank account transactions
     */
    @Override
    @Transactional
    public List<BankAccountTransactions> getTransactions(int theApartmentId) {
        return bankAccountTransactionsRepository.getTransactions(theApartmentId);
    }

}
