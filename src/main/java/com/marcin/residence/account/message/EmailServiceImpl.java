package com.marcin.residence.account.message;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcin.residence.account.balance.ApartmentAccountBalance;

/**
 * Provides the implementation for accessing apartments with an account
 * overdraft and e-mail addresses of their owners.
 * This additional implementation collects the operations due to the subject
 * of the self-starting e-mail service responsible for sending e-mail messages
 * to the owners of the apartments.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    /**
     * Takes a list of account balances for all apartments with an account
     * overdraft and returns a collection of apartment ids mapping to the
     * current total liabilities values (account overdraft) of fetched
     * apartments.
     *
     * @return map of apartment ids and the related total liabilities values
     */
    @Override
    @Transactional
    public Map<Integer, BigDecimal> getApartmentAccountsWithOverdraft() {
        List<ApartmentAccountBalance> accountsList =
                emailRepository.getApartmentAccountsWithOverdraft();
        Map<Integer, BigDecimal> apartmentsWithOverdraft = new TreeMap<>();
        for (ApartmentAccountBalance apartmentAccountBalance : accountsList) {
            apartmentsWithOverdraft.put(apartmentAccountBalance.getId(),
                    apartmentAccountBalance.getTotalLiabilitiesValue());
        }
        return apartmentsWithOverdraft;
    }

    /**
     * Gets a collection of apartment ids mapping to the e-mail addresses
     * of the apartment owners. Map is confined to the apartments with
     * an account overdraft.
     *
     * @return map of apartment ids and the related e-mail addresses of the
     *      apartment owners
     */
    @Override
    @Transactional
    public Map<Integer, String> getEmailAddresses(
            Map<Integer, BigDecimal> apartmentsWithOverdraft) {
        return emailRepository.getEmailAddresses(apartmentsWithOverdraft);
    }
}
