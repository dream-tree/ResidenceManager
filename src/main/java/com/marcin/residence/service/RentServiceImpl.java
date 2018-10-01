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
 * Provides the implementation for calculating and updating the rent for a given apartment 
 * (or for the all available apartments in the database). 
 * All requests should interact with the database through this interface
 * rather than directly through the repository interface.
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
	
	//TODO
	@Override
	public void calculateSingleRent() {	
	}
	
	@Override
	public void calculateAllRents() {
			
		Rates theRates = ratesService.getRates();
		BigDecimal repairFundRate = theRates.getRepairFundRate();
		BigDecimal waterRate = theRates.getWaterRate();
		BigDecimal heatingRate = theRates.getHeatingRate();
		BigDecimal wasteFee = theRates.getWasteFee();
		BigDecimal tvFee = theRates.getTvFee();
		
		List<Apartment> theApartments = apartmentService.getAllApartments();
		
		for(Apartment apartment : theApartments) {
			
			BigDecimal repairFundTotalCost = repairFundRate.multiply(apartment.getArea());
			BigDecimal waterTotalCost = waterRate.multiply(apartment.getWaterConsumption());
			BigDecimal heatingTotalCost = heatingRate.multiply(apartment.getHeaterConsumption());
			BigDecimal wasteFeeTotalCost = wasteFee.multiply(BigDecimal.valueOf(apartment.getNumberOfOccupants()));
			BigDecimal monthlyTotalRent = repairFundTotalCost
							.add(waterTotalCost)
							.add(heatingTotalCost)
							.add(wasteFeeTotalCost)
							.add(tvFee);
			
			Rent theRent = new Rent();
			theRent.setRepairFundTotalCost(repairFundTotalCost);
			theRent.setWaterTotalCost(waterTotalCost);
			theRent.setHeatingTotalCost(heatingTotalCost);
			theRent.setWasteFeeTotalCost(wasteFeeTotalCost);
			theRent.setTvFeeTotal(tvFee);
			theRent.setMonthlyTotalRent(monthlyTotalRent);
			
			apartment.setRent(theRent);
			
			saveAllRents(theApartments);
		}
	}

	//TODO
	@Override
	@Transactional
	public void saveSingleRent(List<Apartment> theApartments) {
		
	}
	
	@Override
	@Transactional
	public void saveAllRents(List<Apartment> theApartments) {
		rentRepository.saveAllRents(theApartments);
	}
}
