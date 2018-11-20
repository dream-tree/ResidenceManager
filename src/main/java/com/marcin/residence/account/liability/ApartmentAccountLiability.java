package com.marcin.residence.account.liability;

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
 * Represents an apartment account liability amount calculated monthly (mainly
 * on the rent basis).
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Entity
@Table(name = "apartment_liability")
public class ApartmentAccountLiability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Date of a new liability value calculation based usually on the apartment
     * rent.
     */
    @Column(name = "calculation_date")
    private LocalDate calculationDate;

    /**
     * Single liability amount usually calculated monthly.
     */
    @Column(name = "liability_value")
    private BigDecimal liabilityValue;

    /**
     * TODO: useless property
     * Determines if a given single liability value
     * {@link ApartmentAccountLiability#liabilityValue} is already included
     * in the apartment account balance value:
     * <ul>
     * <li>0 means liability is not included</li>
     * <li>1 means transaction is included.</li>
     * </ul>
     */
    @Column(name = "liability_flag")
    private boolean liabilityFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    public ApartmentAccountLiability() {
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

    public BigDecimal getLiabilityValue() {
        return liabilityValue;
    }

    public void setLiabilityValue(BigDecimal liabilityValue) {
        this.liabilityValue = liabilityValue;
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
                + ", liabilityValue=" + liabilityValue
                + ", liabilityFlag=" + liabilityFlag + "]";
    }
}
