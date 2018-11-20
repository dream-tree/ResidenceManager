package com.marcin.residence.account.balance;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Rent;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing and updating apartment account balance for a given apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Repository
public class ApartmentAccountBalanceRepositoryImpl implements ApartmentAccountBalanceRepository {

    @Autowired
    private SessionFactory sessionFactory;

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
     * Updates an apartment account balance for all apartments.
     *
     * @param rentList list of all Rent objects in the database
     */
    @Override
    public void updateApartmentAccountBalance(List<Rent> rentList) {
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
    }
}
