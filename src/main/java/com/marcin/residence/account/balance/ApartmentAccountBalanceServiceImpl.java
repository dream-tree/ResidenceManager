package com.marcin.residence.account.balance;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcin.residence.entity.Rent;

/**
 * Provides the implementation for accessing and updating apartment account balance
 * for a given apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class ApartmentAccountBalanceServiceImpl implements ApartmentAccountBalanceService {

    @Autowired
    private ApartmentAccountBalanceRepository apartmentAccountBalanceRepository; 

    /**
     * Gets an apartment account balance for a given apartment.
     *
     * @param theApartmentId database id of an apartment
     * @return apartment account balance for a given apartment
     */
    @Override
    @Transactional
    public ApartmentAccountBalance getApartmentAccountBalance(int theApartmentId) {
        return apartmentAccountBalanceRepository.getApartmentAccountBalance(theApartmentId);
    }

    /**
     * Updates an apartment account balance for all apartments.
     *
     * @param rentList list of all Rent objects in the database
     */
    @Override
    @Transactional
    public void updateApartmentAccountBalance(List<Rent> rentList) {
        apartmentAccountBalanceRepository.updateApartmentAccountBalance(rentList);
    }
}
