package com.marcin.residence.account.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.marcin.residence.account.balance.ApartmentAccountBalanceService;

/**
 * Provides the task scheduler for assigning new bank transfers to the
 * appropriate apartment account and for updating the apartment account balance.
 * Runs every 26th day of each month at 10.30 a.m.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Configuration
@EnableScheduling
public class ApartmentAccountBankTransactionScheduler {

    @Autowired
    private ApartmentAccountBankTransactionService apartmentAccountBankTransactionService;
    @Autowired
    private ApartmentAccountBalanceService apartmentAccountBalanceService;

    /**
     * Gets all bank transactions for every apartment in order to decrease this
     * the apartment account balance due to payment made by the owner into the
     * corresponding bank account (bulk operation).
     */
    @Scheduled(cron = "0 30 10 26 JAN-DEC *")
    public void getApartmentAccountBankTransaction() {
        List<ApartmentAccountBankTransaction> transactionList =
                apartmentAccountBankTransactionService.getAllTransactions();
        updateApartmentAccountBalance(transactionList);
    }

    /**
     * Decreases every involved apartment account balance due to payment made
     * by the owner into the corresponding bank account (bulk operation).
     *
     * @param transactionList list of bank transactions for updating account
     * balance for every involved apartment
     */
    public void updateApartmentAccountBalance(
            List<ApartmentAccountBankTransaction> transactionList) {
        apartmentAccountBalanceService.decreaseApartmentAccountBalance(transactionList);
    }
}
