package com.marcin.residence.account.clearance;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.marcin.residence.entity.Apartment;

/**
 * Represents residence liabilities i.e., all liabilities calculations over
 * time and the current total liabilities amount for a given residence.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Entity
@Table(name = "residence_liabilities")
public class ResidenceLiabilities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Date of a single liability calculation {@link ResidenceLiabilities#singleLiabilityValue}
     * calculated on the basis of an apartment rent, or 
     * date of the calculation of total value of liabilities for a given apartment 
     * {@link ResidenceLiabilities#totalLiabilitiesValue}.
     */
    @Column(name = "calculation_date")
    private LocalDate calculationDate;

    /**
     * Single liability amount calculated monthly.
     */
    @Column(name = "single_liability_value")
    private BigDecimal singleLiabilityValue;

    /**
     *  Total amount of liabilities after the recalculation process i.e, reducing
     *  current liabilities amount by the available bank account transfers.
     */
    @Column(name = "total_liabilities_value")
    private BigDecimal totalLiabilitiesValue;

    /**
     * Determines if a given liability is already repaid i.e.,
     * if liability is already met by available bank account transfers:
     * <ul>
     * <li>0 means liability is not repaid</li>
     * <li>0 means transaction is repaid</li>
     * </ul>
     */
    @Column(name = "liability_flag")
    private boolean liabilityFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    public ResidenceLiabilities() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(LocalDate calculationDate) {
        this.calculationDate = calculationDate;
    }

    public BigDecimal getSingleLiabilityValue() {
        return singleLiabilityValue;
    }

    public void setSingleLiabilityValue(BigDecimal singleLiabilityValue) {
        this.singleLiabilityValue = singleLiabilityValue;
    }

    public BigDecimal getTotalLiabilitiesValue() {
        return totalLiabilitiesValue;
    }

    public void setTotalLiabilitiesValue(BigDecimal totalLiabilitiesValue) {
        this.totalLiabilitiesValue = totalLiabilitiesValue;
    }

    public boolean isLiabilityFlag() {
        return liabilityFlag;
    }

    public void setLiabilityFlag(boolean liabilityFlag) {
        this.liabilityFlag = liabilityFlag;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "ResidenceLiabilities "
                + "[id=" + id
                + ", calculationDate=" + calculationDate
                + ", singleLiabilityValue=" + singleLiabilityValue
                + ", totalLiabilitiesValue=" + totalLiabilitiesValue
                + ", liabilityFlag=" + liabilityFlag + "]";
    }
}
