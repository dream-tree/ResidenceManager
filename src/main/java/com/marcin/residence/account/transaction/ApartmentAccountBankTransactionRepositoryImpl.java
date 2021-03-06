package com.marcin.residence.account.transaction;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing bank account transactions for a given apartment.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Repository
public class ApartmentAccountBankTransactionRepositoryImpl implements
            ApartmentAccountBankTransactionRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets a list of an apartment account bank transactions.
     *
     * @param theApartmentId database id of an apartment
     * @return list of apartment account bank transactions
     */
    @Override
    public List<ApartmentAccountBankTransaction> getApartmentTransactions(int theApartmentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<ApartmentAccountBankTransaction> transactionList =
                currentSession.createQuery(
                        "SELECT a FROM ApartmentAccountBankTransaction a "
                                + "WHERE a.apartment.id = :apartmentId ",
                                ApartmentAccountBankTransaction.class)
                .setParameter("apartmentId", theApartmentId)
                .getResultList();
        return transactionList;
    }

    @Override
    public List<ApartmentAccountBankTransaction> getAllTransactions() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<ApartmentAccountBankTransaction> transactionList =
                currentSession.createQuery(
                        "SELECT a FROM ApartmentAccountBankTransaction a "
                                + "WHERE a.transactionFlag = :transactionNotSettled",
                                ApartmentAccountBankTransaction.class)
                .setParameter("transactionNotSettled", false)
                .getResultList();
        return transactionList;
    }
}