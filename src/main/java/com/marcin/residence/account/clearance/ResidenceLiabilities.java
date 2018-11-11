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
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.marcin.residence.entity.Apartment;

/**
 * Represents current residence bank account transfers value.
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
     * Date of a single liability charge {@link ResidenceLiabilities#singleLiabilityValue}
     * on the basis of an apartment rent or date of the calculation of total value
     * of liabilities for a given apartment {@link ResidenceLiabilities#totalLiabilitiesValue}.
     */
    @Column(name = "charge_date")
    private LocalDate chargeDate;

    /**
     * Single liability value calculated monthly.
     */
    @Column(name = "single_liability_value")
    private BigDecimal singleLiabilityValue;

    /**
     *  Total value of liabilities after the recalculation process i.e, reducing
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

    public LocalDate getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(LocalDate chargeDate) {
        this.chargeDate = chargeDate;
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
                + ", chargeDate=" + chargeDate
                + ", singleLiabilityValue=" + singleLiabilityValue
                + ", totalLiabilitiesValue=" + totalLiabilitiesValue
                + ", liabilityFlag=" + liabilityFlag + "]";
    }
}
