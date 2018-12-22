package com.marcin.residence.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;

import com.marcin.residence.entity.validation.BankAccountNumber;

/**
 * Represents an owner, providing access to its first name, last name,
 * phone number, email, date of birth, PESEL and the bank account number
 * as well as mailing address for a given owner and all of its apartments.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "{notnull.firstName.lastName}")
    @Pattern(regexp = "[a-zA-Z]{1,}",
            message = "{pattern.firstName.lastName}")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "{notnull.firstName.lastName}")
    @Pattern(regexp = "[a-zA-Z]{1,}([-' ]?[a-zA-Z]{1,})?",
    message = "{pattern.firstName.lastName}")
    @Column(name = "last_name")
    private String lastName;

    @Pattern(regexp = "[0-9]{9}",
            message = "{pattern.phoneNumber}")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Pattern(regexp = ".+@.+\\..+",
            message = "{pattern.email}")
    @Column(name = "email")
    private String email;

    @Past(message = "{past.dateOfBirth}")
    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @PESEL(message = "{pattern.pesel}")
    @Column(name = "pesel")
    private String pesel;

    @BankAccountNumber
    @Column(name = "bank_account")
    private String bankAccount;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Apartment> apartments;

    public Owner() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "Owner ["
                + "id=" + id
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", phoneNumber=" + phoneNumber
                + ", email=" + email
                + ", dateOfBirth=" + dateOfBirth
                + ", pesel=" + pesel
                + ", bankAccount=" + bankAccount
                + "]";
    }
}
