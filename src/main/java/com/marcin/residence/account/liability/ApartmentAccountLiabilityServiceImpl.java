package com.marcin.residence.account.liability;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcin.residence.entity.Rent;

/**
 * Provides the implementation for accessing, adding and updating liabilities
 * for a given apartment account.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Service
public class ApartmentAccountLiabilityServiceImpl implements ApartmentAccountLiabilityService {

    @Autowired
    private ApartmentAccountLiabilityRepository apartmentLiability;

    /**
     * Gets a list of liability calculations for a single apartment.
     *
     * @param theApartmentId database id of an apartment
     * @return list of an apartment account liabilities
     */
    @Override
    @Transactional
    public List<ApartmentAccountLiability> getLiabilities(int theApartmentId) {
        return apartmentLiability.getLiabilities(theApartmentId);
    }

    /**
     * Adds new liability value for an apartment. Operation is executed for all
     * apartments available in the database (bulk operation).
     *
     * @param rentList list of rents for all apartments
     */
    @Override
    @Transactional
    public void addAllLiabilities(List<Rent> rentList) {
        apartmentLiability.addAllLiabilities(rentList);
    }
}
