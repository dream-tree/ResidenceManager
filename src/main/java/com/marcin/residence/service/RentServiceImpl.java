package com.marcin.residence.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.Rates;
import com.marcin.residence.entity.Rent;
import com.marcin.residence.repository.RentRepository;

/**
 * Provides the implementation for calculating, adding and updating the rents
 * for all available apartments in the database.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RatesService ratesService;
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private RentRepository rentRepository;

    /**
     * Gets a current Rent for given Apartment.
     * @param theApartmentId database id of an Apartment
     * @return a current Rent for given Apartment
     */
    @Override
    @Transactional
    public Rent getRent(int theApartmentId) {
        return rentRepository.getRent(theApartmentId);
    }

    /**
     * Calculates rents for all apartments in the database after an update
     * on rates for utilities is made.
     * It gets the current rates for utilities and all available Apartments
     * in the database altogether with their fixed cost driving components,
     * and then it calculates new rent for a given apartment based on those
     * factors. In the last step, the new rent for a given apartment is saved
     * in the database.
     */
    @Override
    @Transactional
    public void calculateAllRents() {
        Rates theRates = ratesService.getRates();
        System.out.println("RATES: " + theRates);
        BigDecimal repairFundRate = theRates.getRepairFundRate();
        BigDecimal waterRate = theRates.getWaterRate();
        BigDecimal heatingRate = theRates.getHeatingRate();
        BigDecimal wasteFee = theRates.getWasteFee();
        BigDecimal tvFee = theRates.getTvFee();

        // try-catch clause in case of a new apartment was added but heater or
        // water consumption were not estimated yet (loaded from an external source)
        try {
            List<Apartment> theApartments = apartmentService.getAllApartments();
            System.out.println("APARTMENTS1: " + theApartments.size());
            for (Apartment apartment : theApartments) {
                BigDecimal repairFundTotalCost = repairFundRate.multiply(
                        apartment.getArea());
                BigDecimal waterTotalCost = waterRate.multiply(
                        apartment.getWaterConsumption());
                BigDecimal heatingTotalCost = heatingRate.multiply(
                        apartment.getHeaterConsumption());
                BigDecimal wasteFeeTotalCost = wasteFee.multiply(
                        BigDecimal.valueOf(apartment.getNumberOfOccupants()));
                BigDecimal monthlyTotalRent = repairFundTotalCost
                        .add(waterTotalCost)
                        .add(heatingTotalCost)
                        .add(wasteFeeTotalCost)
                        .add(tvFee);
                System.out.println("APARTMENTS2: " + theApartments);
                Rent theRent = getRent(apartment.getId());
                System.out.println("RENT: " + theRent);
                theRent.setRepairFundTotalCost(repairFundTotalCost);
                theRent.setWaterTotalCost(waterTotalCost);
                theRent.setHeatingTotalCost(heatingTotalCost);
                theRent.setWasteFeeTotalCost(wasteFeeTotalCost);
                theRent.setTvFeeTotal(tvFee);
                theRent.setMonthlyTotalRent(monthlyTotalRent);
                System.out.println("RENT: " + theRent);
                rentRepository.saveRent(theRent);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
