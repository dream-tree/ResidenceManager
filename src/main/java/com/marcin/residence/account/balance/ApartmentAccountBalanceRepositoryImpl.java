package com.marcin.residence.account.balance;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.account.transaction.ApartmentAccountBankTransaction;
import com.marcin.residence.entity.Rent;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing and updating apartment account balance for a given apartment.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Repository
public class ApartmentAccountBalanceRepositoryImpl implements ApartmentAccountBalanceRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Logger logger = Logger.getLogger(getClass().getName());

    /**
     * Gets an apartment account balance for a given apartment.
     *
     * @param theApartmentId database id of an apartment
     * @return apartment account balance for a given apartment
     */
    @Override
    public ApartmentAccountBalance getApartmentAccountBalance(int theApartmentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        ApartmentAccountBalance theBalance =
                currentSession.get(ApartmentAccountBalance.class, theApartmentId);
        return theBalance;
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
    public void increaseApartmentAccountBalance(List<Rent> rentList) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (Rent rent : rentList) {
            currentSession.createQuery("UPDATE ApartmentAccountBalance "
                    + "SET totalLiabilitiesValue = totalLiabilitiesValue + :currentMonthlyRent, "
                    + "calculationDate = :currentDate "
                    + "WHERE id = :apartmentId")
            .setParameter("currentMonthlyRent", rent.getMonthlyTotalRent())
            .setParameter("currentDate", LocalDateTime.now())
            .setParameter("apartmentId", rent.getId())
            .executeUpdate();
        }

        logger.info(">> ApartmentAccountBalanceRepositoryImpl#increaseApartmentAccountBalance: "
                + rentList.size() + " rent(s) submitted to apartment_account_balance table, "
                + "modification ended at " + LocalDateTime.now() + ".");
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
    public void decreaseApartmentAccountBalance(
            List<ApartmentAccountBankTransaction> transactionList) {
        Session currentSession = sessionFactory.getCurrentSession();
        for (ApartmentAccountBankTransaction transaction : transactionList) {
            currentSession.createQuery("UPDATE ApartmentAccountBalance "
                    + "SET totalLiabilitiesValue = totalLiabilitiesValue - :latestTransactions, "
                    + "calculationDate = :currentDate "
                    + "WHERE id = :apartmentId")
            .setParameter("latestTransactions", transaction.getTransactionAmount())
            .setParameter("currentDate", LocalDateTime.now())
            .setParameter("apartmentId", transaction.getApartment().getId())
            .executeUpdate();

            currentSession.createQuery("UPDATE ApartmentAccountBankTransaction "
                    + "SET transactionFlag = true "
                    + "WHERE transactionId = :theTransactionId")
            .setParameter("theTransactionId", transaction.getTransactionId())
            .executeUpdate();
        }

        logger.info(">> ApartmentAccountBalanceRepositoryImpl#decreaseApartmentAccountBalance: "
                + transactionList.size() + " transaction(s) submitted to apartment_account_balance table, "
                + "modification ended at " + LocalDateTime.now() + ".");
    }
}
