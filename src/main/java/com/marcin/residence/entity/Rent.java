package com.marcin.residence.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents a rent for an apartment, providing access to the apartment's
 * repair fund total cost, water total cost, heating total cost,
 * waste fee total cost, TV fee total and the monthly total rent,
 * as well as this particular apartment all these fees belongs to.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Entity
@Table(name = "rent")
public class Rent {

    @Id
    private int id;

    @Column(name = "repair_fund_total_cost")
    private BigDecimal repairFundTotalCost;

    @Column(name = "water_total_cost")
    private BigDecimal waterTotalCost;

    @Column(name = "heating_total_cost")
    private BigDecimal heatingTotalCost;

    @Column(name = "waste_fee_total_cost")
    private BigDecimal wasteFeeTotalCost;

    @Column(name = "tv_fee_total")
    private BigDecimal tvFeeTotal;

    @Column(name = "monthly_total_rent")
    private BigDecimal monthlyTotalRent;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Apartment apartment;

    public Rent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getRepairFundTotalCost() {
        return repairFundTotalCost;
    }

    public void setRepairFundTotalCost(BigDecimal repairFundTotalCost) {
        this.repairFundTotalCost = repairFundTotalCost;
    }

    public BigDecimal getWaterTotalCost() {
        return waterTotalCost;
    }

    public void setWaterTotalCost(BigDecimal waterTotalCost) {
        this.waterTotalCost = waterTotalCost;
    }

    public BigDecimal getHeatingTotalCost() {
        return heatingTotalCost;
    }

    public void setHeatingTotalCost(BigDecimal heatingTotalCost) {
        this.heatingTotalCost = heatingTotalCost;
    }

    public BigDecimal getWasteFeeTotalCost() {
        return wasteFeeTotalCost;
    }

    public void setWasteFeeTotalCost(BigDecimal wasteFeeTotalCost) {
        this.wasteFeeTotalCost = wasteFeeTotalCost;
    }

    public BigDecimal getTvFeeTotal() {
        return tvFeeTotal;
    }

    public void setTvFeeTotal(BigDecimal tvFeeTotal) {
        this.tvFeeTotal = tvFeeTotal;
    }

    public BigDecimal getMonthlyTotalRent() {
        return monthlyTotalRent;
    }

    public void setMonthlyTotalRent(BigDecimal monthlyTotalRent) {
        this.monthlyTotalRent = monthlyTotalRent;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Rent ["
                + "id=" + id
                + ", repairFundTotalCost=" + repairFundTotalCost
                + ", waterTotalCost=" + waterTotalCost
                + ", heatingTotalCost=" + heatingTotalCost
                + ", wasteFeeTotalCost=" + wasteFeeTotalCost
                + ", tvFeeTotal=" + tvFeeTotal
                + ", monthlyTotalRent=" + monthlyTotalRent
                + "]";
    }
}
