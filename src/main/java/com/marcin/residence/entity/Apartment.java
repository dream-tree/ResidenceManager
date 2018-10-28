package com.marcin.residence.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents an apartment, providing access to the apartment's area,
 * number of rooms, number of occupants, media consumption, liabilities
 * and additional info about the particular apartment as well as
 * address for a given apartment, its owner and the rent.
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

    @Column(name = "liabilities")
    private BigDecimal liabilities;

    @Column(name = "notes")
    private String notes;
    
    @Transient
    private ApartmentAddress apartmentAddress;
    
    @Transient
    private Rent rent;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

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

    @Override
    public String toString() {
        return "Apartment "
                + "[id=" + id
                + ", area=" + area
                + ", numberOfRooms=" + numberOfRooms
                + ", numberOfOccupants=" + numberOfOccupants
                + ", waterConsumption=" + waterConsumption
                + ", heaterConsumption=" + heaterConsumption
                + ", liabilities=" + liabilities
                + ", notes=" + notes
                + "]";
    }
}