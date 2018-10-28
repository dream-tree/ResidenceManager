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
 * Provides the implementation for calculating and updating the rents for
 * all available apartments in the database.
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
     * Calculates new rents for all apartments in the database.
     * It gets the current rates for utilities from the database, and also
     * it gets all available Apartments in the database and its fixed
     * cost driving components, and then it calculates new rent for a given
     * apartment based on those factors. In the last step, the new rent for
     * a given apartment is saved in the database.
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

        List<Apartment> theApartments = apartmentService.getAllApartments();
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

            Rent theRent = apartment.getRent();
            theRent.setRepairFundTotalCost(repairFundTotalCost);
            theRent.setWaterTotalCost(waterTotalCost);
            theRent.setHeatingTotalCost(heatingTotalCost);
            theRent.setWasteFeeTotalCost(wasteFeeTotalCost);
            theRent.setTvFeeTotal(tvFee);
            theRent.setMonthlyTotalRent(monthlyTotalRent);

            rentRepository.saveRent(theRent);
        }
    }
}
