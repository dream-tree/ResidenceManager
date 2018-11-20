package com.marcin.residence.account.balance;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.marcin.residence.entity.Apartment;

/**
 * Represents the apartment account balance at a certain point in time.
 * It consist of the current total liabilities value for a given residence
 * as well as the date of the recalculation operation.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Entity
@Table(name = "apartment_account_balance")
public class ApartmentAccountBalance {

    @Id
    private int id;

    /**
     *  Total amount of liabilities as a result of a single recalculation
     *  operation i.e.:
     *  <ul>
     *  <li>operation of calculation of the new monthly rent value, triggering
     *  an increment of the apartment total liabilities value</li>
     *  <li>operation of fetching available bank account transfers, triggering
     *  the reduction of current total liabilities amount.</li>
     *  </ul>
     */
    @Column(name = "total_liabilities_value")
    private BigDecimal totalLiabilitiesValue;

    /**
     * Date and time of the recalculation operation.
     */
    @Column(name = "calculation_date")
    private LocalDateTime calculationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Apartment apartment;

    public ApartmentAccountBalance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getTotalLiabilitiesValue() {
        return totalLiabilitiesValue;
    }

    public void setTotalLiabilitiesValue(BigDecimal totalLiabilitiesValue) {
        this.totalLiabilitiesValue = totalLiabilitiesValue;
    }

    public LocalDateTime getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(LocalDateTime calculationDate) {
        this.calculationDate = calculationDate;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "ApartmentAccountBalance "
                + "[id=" + id
                + ", totalLiabilitiesValue=" + totalLiabilitiesValue
                + ", calculationDate=" + calculationDate + "]";
    }
}
