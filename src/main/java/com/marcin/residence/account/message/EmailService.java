package com.marcin.residence.account.message;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Provides the service for accessing apartments with an account overdraft and
 * e-mail addresses of their owners.
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
 * This additional service collects the operations due to the subject of
 * the self-starting e-mail service responsible for sending e-mail messages
 * to the owners of the apartments.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
public interface EmailService {

    /**
     * Takes a list of account balances for all apartments with an account
     * overdraft and returns a collection of apartment ids mapping to the
     * current total liabilities values (account overdraft) of all fetched
     * apartments.
     *
     * @return map of apartment ids and the related total liabilities values
     */
    Map<Integer, BigDecimal> getApartmentAccountsWithOverdraft();

    /**
     * Gets a collection of apartment ids mapping to the e-mail addresses
     * of the apartment owners. Map is confined to the apartments with
     * an account overdraft.
     *
     * @return map of apartment ids and the related e-mail addresses of the
     *      apartment owners
     */
    Map<Integer, String> getEmailAddresses(
            Map<Integer, BigDecimal> apartmentsWithOverdraft);

}
