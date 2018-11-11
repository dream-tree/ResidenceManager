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
 * Represents individual bank account transactions for a given apartment i.e.,
 * owner transfers into bank account associated with given apartment.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Entity
@Table(name = "bank_account_transactions ")
public class BankAccountTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Bank id of a single transaction.
     */
    @Column(name = "transaction_id")
    private String transactionId;

    /**
     * Date of a single transaction.
     */
    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    /**
     * Amount of a single transaction.
     */
    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;

    /**
     * Determines if a given transaction is already cleared i.e.,
     * if liabilities are already reduced by this particular
     * transaction amount:
     * <ul>
     * <li>0 means transaction is not cleared</li>
     * <li>0 means transaction is cleared</li>
     * </ul>
     */
    @Column(name = "transaction_flag")
    private boolean transactionFlag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

/*    *//**
     * Bank account number.
     *//*
    @Column(name = "account_number")
    private BigDecimal accountNumber;*/

    public BankAccountTransactions() {
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public boolean isTransactionFlag() {
        return transactionFlag;
    }

    public void setTransactionFlag(boolean transactionFlag) {
        this.transactionFlag = transactionFlag;
    }

    @Override
    public String toString() {
        return "BankAccountTransactions "
                + "[id=" + id
                + ", transactionId=" + transactionId
                + ", transactionAmount=" + transactionAmount
                + ", transactionDate=" + transactionDate
                + ", transactionFlag=" + transactionFlag
               /* + ", accountNumber=" + accountNumber + "]"*/;
    }
}
