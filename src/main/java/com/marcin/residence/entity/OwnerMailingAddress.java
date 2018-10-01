package com.marcin.residence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 * Represents a mailing address for a given owner, providing access to the name of the street and the number, 
 * the city and the postal code as well as the owner a given apartment.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Entity
@Table(name="owner_mailing_address")
public class OwnerMailingAddress {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Pattern(regexp="[ a-zA-Z]+", message="{pattern.street.city}")
	@Column(name="street")
	private String street;
	
	@Pattern(regexp="\\d+[a-zA-Z]?(/\\d+[a-zA-Z]?)?", message="{pattern.apartmentNumber}")
	@Column(name="apartment_number")
	private String apartmentNumber;
	
	@Pattern(regexp="[a-zA-Z]+([ -][a-zA-Z]+)?", message="{pattern.street.city}")
	@Column(name="city")
	private String city;
	
	@Pattern(regexp="\\d{2}-\\d{3}", message="{pattern.postalCode}")
	@Column(name="postal_code")
	private String postalCode;
	
	@OneToOne(mappedBy="ownerMailingAddress")
	private Owner owner;

	public OwnerMailingAddress() {
	}
	
	public OwnerMailingAddress(String street, String apartmentNumber, String city, String postalCode, Owner owner) {
		this.street = street;
		this.apartmentNumber = apartmentNumber;
		this.city = city;
		this.postalCode = postalCode;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "OwnerMailingAddress [id=" + id + ", street=" + street + ", apartmentNumber=" + apartmentNumber
				+ ", city=" + city + ", postalCode=" + postalCode + ", owner=" + owner + "]";
	}
}
