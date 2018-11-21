package com.marcin.residence.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.marcin.residence.account.balance.ApartmentAccountBalance;
import com.marcin.residence.account.liability.ApartmentAccountLiability;
import com.marcin.residence.account.transaction.ApartmentAccountBankTransaction;

/**
 * Represents an apartment, providing access to the apartment's area,
 * number of rooms, number of occupants, media consumption, liabilities
 * and additional info about the particular apartment as well as an address
 * for a given apartment, its owner and the rent.
 *
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Entity
@Table(name = "apartment")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "area")
    private BigDecimal area;

    @Column(name = "number_of_rooms")
    private int numberOfRooms;

    @Column(name = "number_of_occupants")
    private int numberOfOccupants;

    @Column(name = "water_consumption")
    private BigDecimal waterConsumption;

    @Column(name = "heater_consumption")
    private BigDecimal heaterConsumption;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Transient
    private ApartmentAddress apartmentAddress;

    @Transient
    private Rent rent;

    @Transient
    private ApartmentAccountBalance apartmentAccountBalance;

    public Apartment() {
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

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfOccupants() {
        return numberOfOccupants;
    }

    public void setNumberOfOccupants(int numberOfOccupants) {
        this.numberOfOccupants = numberOfOccupants;
    }

    public BigDecimal getWaterConsumption() {
        return waterConsumption;
    }

    public void setWaterConsumption(BigDecimal waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    public BigDecimal getHeaterConsumption() {
        return heaterConsumption;
    }

    public void setHeaterConsumption(BigDecimal heaterConsumption) {
        this.heaterConsumption = heaterConsumption;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public ApartmentAddress getApartmentAddress() {
        return apartmentAddress;
    }

    public void setApartmentAddress(ApartmentAddress apartmentAddress) {
        this.apartmentAddress = apartmentAddress;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public ApartmentAccountBalance getApartmentAccountBalance() {
        return apartmentAccountBalance;
    }

    public void setApartmentAccountBalance(ApartmentAccountBalance apartmentAccountBalance) {
        this.apartmentAccountBalance = apartmentAccountBalance;
    }

    @Override
    public String toString() {
        return "Apartment "
                + "[id=" + id
                + ", area=" + area
                + ", numberOfRooms=" + numberOfRooms
                + ", numberOfOccupants=" + numberOfOccupants
                + ", waterConsumption=" + waterConsumption
                + ", heaterConsumption=" + heaterConsumption
                + ", notes=" + notes
                + "]";
    }
}