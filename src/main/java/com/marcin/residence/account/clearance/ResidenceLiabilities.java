package com.marcin.residence.account.clearance;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Represents current residence bank account transfers value. 
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Entity
@Table(name = "residence_liabilities")
public class ResidenceLiabilities {

    @Column(name = "id")
    private int id;
    
    @Column(name = "liabilities_value")
    private BigDecimal liabilitiesValue;

    public ResidenceLiabilities() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getLiabilitiesValue() {
        return liabilitiesValue;
    }

    public void setLiabilitiesValue(BigDecimal liabilitiesValue) {
        this.liabilitiesValue = liabilitiesValue;
    }
}
