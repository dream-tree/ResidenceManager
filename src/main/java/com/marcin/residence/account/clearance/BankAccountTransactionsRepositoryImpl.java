package com.marcin.residence.account.clearance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing bank account transactions for a given Apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Repository
public class BankAccountTransactionsRepositoryImpl implements BankAccountTransactionsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets a list of bank account transactions for a given Apartment.
     *
     * @param theApartmentId database id of an Apartment
     * @return list of bank account transactions
     */
    @Override
    public List<BankAccountTransactions> getTransactions(int theApartmentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<BankAccountTransactions> transactionList =
                currentSession.createQuery(
                        "SELECT b FROM BankAccountTransactions b "
                                + "WHERE b.apartment.id=:apartmentId ",
                                BankAccountTransactions.class)
                .setParameter("apartmentId", theApartmentId)
                .getResultList();
        return transactionList;
    }
}