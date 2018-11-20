package com.marcin.residence.account.liability;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.entity.Rent;


/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing, adding and updating liabilities for a given apartment account.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Repository
public class ApartmentAccountLiabilityRepositoryImpl implements ApartmentAccountLiabilityRepository {

    @Autowired
    private SessionFactory sessionFactory;
    
    private Logger logger = Logger.getLogger(getClass().getName());
    
    /**
     * Gets a list of all liability calculations for a single apartment.
     *
     * @param theApartmentId database id of an apartment
     * @return list of an apartment account liabilities
     */
    @Override
    public List<ApartmentAccountLiability> getLiabilities(int theApartmentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<ApartmentAccountLiability> liabilitiesList =
                currentSession.createQuery(
                        "SELECT al FROM ApartmentLiability al "
                                + "WHERE al.apartment.id=:apartmentId "
                                + "ORDER BY al.calculationDate",
                                ApartmentAccountLiability.class)
                .setParameter("apartmentId", theApartmentId)
                .getResultList();
        return liabilitiesList;
    }

    /**
     * Adds new liability value for an apartment. Operation is executed for all
     * apartments available in the database (bulk operation).
     *
     * @param rentList list of rents for all apartments
     */

    @Override
    public void addAllLiabilities(List<Rent> rentList) {
        String calculationDate = LocalDate.now().toString();
        boolean liabilityFlag = false;
        int sum = 0;
        String insertString =
            "INSERT INTO apartment_liability ("
                    + "calculation_date, liability_flag, liability_value, apartment_id) "
                    + "VALUES (STR_TO_DATE('" +  calculationDate + "','%Y-%m-%d'), "
                    + liabilityFlag + ", ?, ?)";
        Session currentSession = sessionFactory.getCurrentSession();
        for (Rent rent : rentList) {
            sum += currentSession.createSQLQuery(insertString)
                    .setParameter(1, rent.getMonthlyTotalRent())
                    .setParameter(2, rent.getId())
                    .executeUpdate();
        }
        logger.info(">> ApartmentLiabilityRepositoryImpl#addAllLiabilities: "
                + sum + " rows in apartment_liability table were modified at "
                        + LocalDateTime.now() + ".");
    }
}