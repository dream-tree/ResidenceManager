package com.marcin.residence.account.liability;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.marcin.residence.account.balance.ApartmentAccountBalanceService;
import com.marcin.residence.entity.Rent;
import com.marcin.residence.service.RentService;

/**
 * Provides the task scheduler for adding monthly rent to the apartment
 * liabilities and for updating the apartment account balance.
 * Runs every 25th day of each month at 10.30 a.m.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Configuration
@EnableScheduling
public class ApartmentAccountLiabilityScheduler {

    @Autowired
    private RentService rentService;
    @Autowired
    private ApartmentAccountLiabilityService apartmentLiabilityService;
    @Autowired
    private ApartmentAccountBalanceService apartmentAccountBalanceService;

    /**
     * Gets all Rent objects (with an id and a monthlyTotalRent properties only)
     * and adds a new liability for every single apartment in the database based
     * on the current rent amount (bulk operation).
     * Note: every Rent entity shares the Primary Key with the Apartment entity
     * (@MapsId annotation used).
     */
    @Scheduled(cron = "0 30 10 25 JAN-DEC *")
    public void addCurrentMonthlyRentToApartmentAccountLiability() {
        List<Rent> rentList = rentService.getAllRents();
        apartmentLiabilityService.addAllLiabilities(rentList);
        increaseApartmentAccountBalance(rentList);
    }

    /**
     * Updates every apartment account balance with a new liability based on
     * the current rent amount (bulk operation).
     * Note: ApartmentLiability entity DOES NOT SHARE the Primary Key with
     * the Apartment entity. That`s why an INSERT INTO statement with specified
     * apartment_id is used in the repository instead of save() method.
     *
     * @param rentList list of rents for all apartments in the database
     */
    public void increaseApartmentAccountBalance(List<Rent> rentList) {
        apartmentAccountBalanceService.increaseApartmentAccountBalance(rentList);
    }
}
