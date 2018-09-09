package com.marcin.residence.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="apartment")
public class Apartment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="area")
	private BigDecimal area;
	
	@Column(name="number_of_rooms")
	private Integer numberOfRooms;
	
	@Column(name="rent")
	private BigDecimal rent;
	
	@Column(name="liabilities")
	private BigDecimal liabilities;
	
	@Column(name="notes")
	private String notes;
	
	@OneToOne(cascade=CascadeType.ALL/*, fetch=FetchType.LAZY*/)
	@JoinColumn(name="apartment_address_id")
	private ApartmentAddress apartmentAddress;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	public Apartment() {
	}

	public Apartment(BigDecimal area, Integer numberOfRooms, BigDecimal rent, BigDecimal liabilities, String notes,
			ApartmentAddress apartmentAddress, Owner owner) {
		this.area = area;
		this.numberOfRooms = numberOfRooms;
		this.rent = rent;
		this.liabilities = liabilities;
		this.notes = notes;
		this.apartmentAddress=apartmentAddress;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public Integer getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(Integer numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public BigDecimal getRent() {
		return rent;
	}

	public void setRent(BigDecimal rent) {
		this.rent = rent;
	}

	public BigDecimal getLiabilities() {
		return liabilities;
	}

	public void setLiabilities(BigDecimal liabilities) {
		this.liabilities = liabilities;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ApartmentAddress getApartmentAddress() {
		return apartmentAddress;
	}

	public void setApartmentAddress(ApartmentAddress apartmentAddress) {
		this.apartmentAddress = apartmentAddress;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Apartment [id=" + id + ", area=" + area + ", numberOfRooms=" + numberOfRooms + ", rent=" + rent
				+ ", liabilities=" + liabilities + ", notes=" + notes + "]";
	}
}

