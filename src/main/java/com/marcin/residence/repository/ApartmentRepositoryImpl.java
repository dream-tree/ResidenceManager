package com.marcin.residence.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.marcin.residence.account.balance.ApartmentAccountBalance;
import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.entity.Rent;

/**
 * Provides the implementation for CRUD operations and common queries, i.e.
 * for accessing, adding, updating and deleting an apartment (or apartments).
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Repository
public class ApartmentRepositoryImpl implements ApartmentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets a single apartment from the database based on the apartment id.
     *
     * @param theApartmentId database id of an apartment
     * @return an apartment with the given id
     */
    @Override
    public Apartment getSingleApartment(int theApartmentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Apartment theApartment = currentSession.createQuery(
                "SELECT a FROM Apartment a "
                        + "WHERE a.id = :id", Apartment.class)
                .setParameter("id", theApartmentId)
                .getSingleResult();
        return theApartment;
    }

    /**
     * Gets all apartments belonging to a given owner based on the owner id.
     *
     * @param theOwnerId database id of an owner
     * @return all apartments of a given owner
     */
    @Override
    public List<Apartment> getOwnerApartments(int theOwnerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Apartment> apartments = currentSession.createQuery(
                "SELECT a FROM Apartment a "
                        + "WHERE a.owner.id = :id ",
                        Apartment.class)
                .setParameter("id", theOwnerId)
                .getResultList();
        return apartments;
    }

    /**
     * Gets all apartments from the database.
     *
     * @return all apartments in the database
     */
    @Override
    public List<Apartment> getAllApartments() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Apartment> apartments = currentSession.createQuery(
                "FROM Apartment", Apartment.class)
                .getResultList();
        return apartments;
    }

    /**
     * Updates an existing apartment in the database.
     *
     * @param theApartment an apartment to be updated
     */
    @Override
    public void updateApartment(Apartment theApartment) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(theApartment);
    }

    /**
     * Saves a new apartment in the database altogether with the predefined rent,
     * apartment address and apartment account balance.
     *
     * @param theApartment a new apartment to be saved
     * @param theRent a predefined ("zero" values) apartment rent to be saved
     * @param theApartmentAddress a predefined apartment address to be saved
     * @param theBalance a predefined ("zero" values) apartment account balance
     *          to be saved
     */
    @Override
    public void saveApartment(Apartment theApartment, Rent theRent,
            ApartmentAddress theApartmentAddress, ApartmentAccountBalance theBalance) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(theApartment);
        currentSession.save(theApartmentAddress);
        currentSession.save(theRent);
        currentSession.save(theBalance);
    }

    /**
     * Deletes an apartment of a given id from the database.
     *
     * @param theApartmentId database id of an apartment
     */
    @Override
    public void deleteApartment(int theApartmentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Apartment theApartment = currentSession.get(Apartment.class, theApartmentId);
        currentSession.delete(theApartment);
    }
}
