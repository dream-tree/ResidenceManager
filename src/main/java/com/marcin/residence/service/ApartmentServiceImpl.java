package com.marcin.residence.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.residence.account.balance.ApartmentAccountBalance;
import com.marcin.residence.account.balance.ApartmentAccountBalanceRepository;
import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.entity.Rent;
import com.marcin.residence.repository.ApartmentAddressRepository;
import com.marcin.residence.repository.ApartmentRepository;
import com.marcin.residence.repository.RentRepository;

/**
 * Provides the implementation for accessing, adding, updating and deleting
 * an Apartment (or Apartment-s).
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private ApartmentAddressRepository apartmentAddressRepository;
    @Autowired
    private ApartmentAccountBalanceRepository apartmentAccountBalanceRepository;
    
    /**
     * Gets a single apartment from the database based on the apartment id.
     *
     * @param theApartmentId database id of an apartment
     * @return an apartment retrieved from the database
     */
    @Override
    @Transactional
    public Apartment getSingleApartment(int theApartmentId) {
        return apartmentRepository.getSingleApartment(theApartmentId);
    }

    /**
     * Gets all apartments of a given owner from the database based on the 
     * the owner id. It also sets the corresponding ApartmentAddress, Rent and
     * ApartmentAccountBalance properties to the retrieved Apartment to show
     * the required information to the end-user on a web page.
     *
     * @param theOwnerId database id of an owner
     * @return list of apartments retrieved from the database
     */
    @Override
    @Transactional
    public List<Apartment> getOwnerApartments(int theOwnerId) {
        List<Apartment> theApartments = apartmentRepository.getOwnerApartments(theOwnerId);
        for (Apartment apartment : theApartments) {
            int theApartmentId = apartment.getId();
            ApartmentAddress apartmentAddress =
                    apartmentAddressRepository.getApartmentAddress(theApartmentId);
            apartment.setApartmentAddress(apartmentAddress);
            Rent rent = rentRepository.getRent(theApartmentId);
            apartment.setRent(rent);
            ApartmentAccountBalance balance =
                    apartmentAccountBalanceRepository.getApartmentAccountBalance(theApartmentId);
            apartment.setApartmentAccountBalance(balance);
        }
        return theApartments;
    }

    /**
     * Gets all apartments from the database.
     *
     * @return list of all apartments retrieved from the database
     */
    @Override
    @Transactional
    public List<Apartment> getAllApartments() {
        return apartmentRepository.getAllApartments();
    }

    /**
     * Saves or updates a single apartment in the database. Every single
     * new apartment is saved altogether with the predefined ("zero" values)
     * rent, apartment account balance and the apartment address.
     *
     * @param theApartment an apartment to be saved or updated in the database
     */
    @Override
    @Transactional
    public void saveApartment(Apartment theApartment) {
        int theApartmentId = theApartment.getId();
        if (theApartmentId != 0) {
            apartmentRepository.updateApartment(theApartment);
        } else {
            ApartmentAddress theApartmentAddress = new ApartmentAddress();
            theApartmentAddress.setApartment(theApartment);
            Rent theRent = createPredefinedRent();
            theRent.setApartment(theApartment);
            ApartmentAccountBalance theBalance = createPredefinedApartmentAccountBalance();
            theBalance.setApartment(theApartment);
            apartmentRepository.saveApartment(theApartment, theRent, theApartmentAddress,
                    theBalance);
        }
    }

    /**
     * Deletes a single apartment from the database based on the id of an apartment.
     *
     * @param theApartmentId id of an apartment to be deleted from the database
     */
    @Override
    @Transactional
    public void deleteApartment(int theApartmentId) {
        apartmentRepository.deleteApartment(theApartmentId);
    }
    
    /**
     * Constructs new Rent object for an Apartment setting its property values to zero.
     *
     * @return a new Rent object
     */
    public Rent createPredefinedRent() {
        Rent theRent = new Rent();
        theRent.setHeatingTotalCost(BigDecimal.valueOf(0.0));
        theRent.setRepairFundTotalCost(BigDecimal.valueOf(0.0));
        theRent.setTvFeeTotal(BigDecimal.valueOf(0.0));
        theRent.setWasteFeeTotalCost(BigDecimal.valueOf(0.0));
        theRent.setWaterTotalCost(BigDecimal.valueOf(0.0));
        theRent.setMonthlyTotalRent(BigDecimal.valueOf(0.0));      
        return theRent;
    }
    
    /**
     * Constructs new ApartmentAccountBalance object for an Apartment
     * setting its property values to zero.
     *
     * @return a new ApartmentAccountBalance object
     */
    public ApartmentAccountBalance createPredefinedApartmentAccountBalance() {
        ApartmentAccountBalance theBalance = new ApartmentAccountBalance();
        theBalance.setTotalLiabilitiesValue(BigDecimal.valueOf(0.0));
        theBalance.setCalculationDate(LocalDateTime.now());
        return theBalance;
    }     
}
