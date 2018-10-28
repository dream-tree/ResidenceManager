package com.marcin.residence.account.clearance;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Represents current owner's bank account transfers value. 
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Entity
@Table(name = "transfers")
public class BankAccountTransfersState {

    @Column(name = "id")
    private int id;
    
    @Column(name = "current_transfer_value")
    private BigDecimal currentTransferValue;

    public BankAccountTransfersState() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getCurrentTransferValue() {
        return currentTransferValue;
    }

    public void setCurrentTransferValue(BigDecimal currentTransferValue) {
        this.currentTransferValue = currentTransferValue;
    }   
}
