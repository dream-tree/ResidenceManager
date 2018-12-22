package com.marcin.residence.account.message;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.account.balance.ApartmentAccountBalance;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing apartments with an account overdraft and e-mail addresses
 * of their owners.
 * This additional repository implementation collects the operations due to the
 * subject of the self-starting e-mail service responsible for sending e-mail
 * messages to the owners of the apartments.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Repository
public class EmailRepositoryImpl implements EmailRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets list of account balances for all apartments with an account
     * overdraft.
     *
     * @return list of apartment account balances with an account overdraft
     */
    @Override
    public List<ApartmentAccountBalance> getApartmentAccountsWithOverdraft() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<ApartmentAccountBalance> accountsList = currentSession.createQuery(
                "FROM ApartmentAccountBalance "
                        + "WHERE totalLiabilitiesValue < 0 ",
                        ApartmentAccountBalance.class)
           .getResultList();
        return accountsList;
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
    public Map<Integer, String> getEmailAddresses(
            Map<Integer, BigDecimal> apartmentsWithOverdraft) {
        Session currentSession = sessionFactory.getCurrentSession();
        Map<Integer, String> apartmentIdToEmail = new TreeMap<>();
        for (Integer apartmentId : apartmentsWithOverdraft.keySet()) {
            String emailAddress = (String) currentSession.createQuery(
                    "SELECT owner.email FROM Apartment "
                            + "WHERE id = :theApartmentId ")
                .setParameter("theApartmentId", apartmentId)
                .getSingleResult();
            apartmentIdToEmail.put(apartmentId, emailAddress);
        }
        return apartmentIdToEmail;
    }
}
