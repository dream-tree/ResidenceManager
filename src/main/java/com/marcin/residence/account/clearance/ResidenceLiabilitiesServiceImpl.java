package com.marcin.residence.account.clearance;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides the implementation for accessing the Apartment liabilities.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Service
public class ResidenceLiabilitiesServiceImpl implements ResidenceLiabilitiesService {

    @Autowired
    private ResidenceLiabilitiesRepository residenceLiabilitiesRepository;

    /**
     * Gets a list of liabilities for a given Apartment.
     *
     * @param theApartmentId database id of an Apartment
     * @return list of an Apartment liabilities
     */
    @Override
    @Transactional
    public List<ResidenceLiabilities> getLiabilities(int theApartmentId) {
        return residenceLiabilitiesRepository.getLiabilities(theApartmentId);
    }

}
