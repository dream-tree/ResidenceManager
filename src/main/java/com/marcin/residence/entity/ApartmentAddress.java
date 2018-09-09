package com.marcin.residence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="apartment_address")
public class ApartmentAddress {

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

	@OneToOne(mappedBy="apartmentAddress")
	private Apartment apartment;
	
	public ApartmentAddress() {		
	}

	public ApartmentAddress(String street, String apartmentNumber, String city, String postalCode, Apartment apartment) {
		this.street = street;
		this.apartmentNumber = apartmentNumber;
		this.city = city;
		this.postalCode = postalCode;
		this.apartment=apartment;
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

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@Override
	public String toString() {
		return "ApartmentAddress [id=" + id + ", street=" + street + ", apartmentNumber=" + apartmentNumber + ", city="
				+ city + ", postalCode=" + postalCode + "]";
	}
}
