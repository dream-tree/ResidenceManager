package com.marcin.residence.account.message;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.marcin.residence.account.balance.ApartmentAccountBalance;

/**
 * Provides the interface for CRUD operations and common queries, i.e.
 * for accessing apartments with an account overdraft and e-mail addresses
 * of their owners.
 * This additional repository collects the operations due to the subject of
 * the self-starting e-mail service responsible for sending e-mail messages
 * to the owners of the apartments.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
public interface EmailRepository {

    /**
     * Gets list of account balances for all apartments with an account
     * overdraft.
     *
     * @return list of apartment account balances with an account overdraft
     */
    List<ApartmentAccountBalance> getApartmentAccountsWithOverdraft();

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
