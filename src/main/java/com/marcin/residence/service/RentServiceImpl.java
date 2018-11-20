package com.marcin.residence.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.Rates;
import com.marcin.residence.entity.Rent;
import com.marcin.residence.repository.RentRepository;
import com.sun.mail.handlers.image_gif;

/**
 * Provides the implementation for accessing, adding and updating (calculating)
 * rent for an apartment.
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
    
    private Logger logger = Logger.getLogger(getClass().getName());

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
     * It gets the current rates for utilities and all available apartments
     * altogether with their fixed cost driving components, and then it
     * calculates new rent for a given apartment based on those factors.
     * In the last step, the new rent for a given apartment is saved
     * in the database.
     */
    @Override
    @Transactional
    public void calculateAllRents() {
        Rates theRates = ratesService.getRates();
        BigDecimal repairFundRate = theRates.getRepairFundRate();
        BigDecimal waterRate = theRates.getWaterRate();
        BigDecimal heatingRate = theRates.getHeatingRate();
        BigDecimal wasteFee = theRates.getWasteFee();
        BigDecimal tvFee = theRates.getTvFee();
        int i = 0;
        // try-catch clause used in case of a new apartment was added but the heater 
        // or water consumption, loaded from an external source, were not estimated yet
        try {
            List<Apartment> theApartments = apartmentService.getAllApartments();
            for (Apartment apartment : theApartments) {
                i++;
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
                Rent theRent = getRent(apartment.getId());
                theRent.setRepairFundTotalCost(repairFundTotalCost);
                theRent.setWaterTotalCost(waterTotalCost);
                theRent.setHeatingTotalCost(heatingTotalCost);
                theRent.setWasteFeeTotalCost(wasteFeeTotalCost);
                theRent.setTvFeeTotal(tvFee);
                theRent.setMonthlyTotalRent(monthlyTotalRent);
                System.out.println("Apartment # " + i + ", " + apartment);
                System.out.println("Rent      # " + i + ", " + theRent);
                rentRepository.saveRent(theRent);
            }
        } catch (Exception ex) {
            logger.info(">> RentServiceImpl#calculateAllRents: " + ex.getMessage());
        }
    }
    
    /**
     * Gets all rents for all apartments in order to calculate current
     * apartments liabilities.
     *
     * @return list of Rent objects
     */
    @Override
    @Transactional
    public List<Rent> getAllRents() {
        return rentRepository.getAllRents();
    }
}
