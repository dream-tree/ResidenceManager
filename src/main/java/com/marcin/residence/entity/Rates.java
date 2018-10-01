package com.marcin.residence.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Represents the rates for the apartmemt utilities, providing access to the repair fund rate, water rate,
 * heating rate, waste fee and the TV fee.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Entity
@Table(name="rates")
public class Rates {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="repair_fund_rate")
	@NotNull(message="{notnull.rates}")
	@Digits(integer=4, fraction=2, message="{digits.rates}")
	@DecimalMin("0.00")
	private BigDecimal repairFundRate;
	
	@Column(name="water_rate")
	@NotNull(message="{notnull.rates}")
	@Digits(integer=4, fraction=2, message="{digits.rates}")
	@DecimalMin("0.00")
	private BigDecimal waterRate;
	
	@Column(name="heating_rate")
	@NotNull(message="{notnull.rates}")
	@Digits(integer=4, fraction=2, message="{digits.rates}")
	@DecimalMin("0.00")
	private BigDecimal heatingRate;
	
	@Column(name="waste_fee")
	@NotNull(message="{notnull.rates}")
	@Digits(integer=4, fraction=2, message="{digits.rates}")
	@DecimalMin(value="0.00")
	private BigDecimal wasteFee;
	
	@Column(name="tv_fee")
	@NotNull(message="{notnull.rates}")
	@Digits(integer=4, fraction=2, message="{digits.rates}")
	@DecimalMin("0.00")
	private BigDecimal tvFee;
	
	public Rates() {		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getRepairFundRate() {
		return repairFundRate;
	}

	public void setRepairFundRate(BigDecimal repairFundRate) {
		this.repairFundRate = repairFundRate;
	}

	public BigDecimal getWaterRate() {
		return waterRate;
	}

	public void setWaterRate(BigDecimal waterRate) {
		this.waterRate = waterRate;
	}

	public BigDecimal getHeatingRate() {
		return heatingRate;
	}

	public void setHeatingRate(BigDecimal heatingRate) {
		this.heatingRate = heatingRate;
	}

	public BigDecimal getWasteFee() {
		return wasteFee;
	}

	public void setWasteFee(BigDecimal wasteFee) {
		this.wasteFee = wasteFee;
	}

	public BigDecimal getTvFee() {
		return tvFee;
	}

	public void setTvFee(BigDecimal tvFee) {
		this.tvFee = tvFee;
	}

	@Override
	public String toString() {
		return "Rates [id=" + id + ", repairFundRate=" + repairFundRate + ", waterRate=" + waterRate + ", heatingRate="
				+ heatingRate + ", wasteFee=" + wasteFee + ", tvFee=" + tvFee + "]";
	}
}
