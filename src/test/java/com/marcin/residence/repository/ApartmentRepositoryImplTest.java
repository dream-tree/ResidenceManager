package com.marcin.residence.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.persistence.NoResultException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.marcin.residence.config.AppConfig;
import com.marcin.residence.config.DispatcherServletInitializer;
import com.marcin.residence.entity.Apartment;
import com.marcin.residence.service.ApartmentService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DispatcherServletInitializer.class, AppConfig.class })
public class ApartmentRepositoryImplTest {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ApartmentService service;

    @Test
    public void testGetSingleApartment() {
        Apartment expected = new Apartment();
        expected.setArea(BigDecimal.valueOf(63.60).setScale(2, RoundingMode.UNNECESSARY));
        expected.setNumberOfRooms(4);
        expected.setNumberOfOccupants(2);
        expected.setWaterConsumption(BigDecimal.valueOf(185.78));
        expected.setHeaterConsumption(BigDecimal.valueOf(1254.43));
        expected.setLiabilities(BigDecimal.valueOf(0.00).setScale(2, RoundingMode.UNNECESSARY));
        expected.setNotes("No info collected");

        Apartment actual =  service.getSingleApartment(1);

        assertEquals(expected.getArea(), actual.getArea());
        assertEquals(expected.getNumberOfRooms(), actual.getNumberOfRooms());
        assertEquals(expected.getNumberOfOccupants(), actual.getNumberOfOccupants());
        assertEquals(expected.getWaterConsumption(), actual.getWaterConsumption());
        assertEquals(expected.getHeaterConsumption(), actual.getHeaterConsumption());
        assertEquals(expected.getLiabilities(), actual.getLiabilities());
        assertEquals(expected.getNotes(), actual.getNotes());
    }

    @Test(expected=NoResultException.class)
    public void testGetSingleNonExistingApartment() {
        service.getSingleApartment(75);
    }

    @Test
    public void testGetOwnerApartments() {
        Apartment expectedApartmentId6 = new Apartment();
        expectedApartmentId6.setArea(BigDecimal.valueOf(55.0)
                .setScale(2, RoundingMode.UNNECESSARY));
        expectedApartmentId6.setNumberOfRooms(3);
        expectedApartmentId6.setNumberOfOccupants(2);
        expectedApartmentId6.setWaterConsumption(BigDecimal.valueOf(55.18));
        expectedApartmentId6.setHeaterConsumption(BigDecimal.valueOf(428.21));
        expectedApartmentId6.setLiabilities(BigDecimal.valueOf(0.00)
                .setScale(2, RoundingMode.UNNECESSARY));
        expectedApartmentId6.setNotes("Restoration in progress.");

        List<Apartment> actualListOwnerId10005 =  service.getOwnerApartments(10005);
        List<Apartment> actualListOwnerId10004 =  service.getOwnerApartments(10004);

        assertEquals(3, actualListOwnerId10005.size());
        assertEquals(0, actualListOwnerId10004.size());

        assertEquals(expectedApartmentId6.getArea(),
                actualListOwnerId10005.get(2).getArea());
        assertEquals(expectedApartmentId6.getNumberOfRooms(),
                actualListOwnerId10005.get(2).getNumberOfRooms());
        assertEquals(expectedApartmentId6.getNumberOfOccupants(),
                actualListOwnerId10005.get(2).getNumberOfOccupants());
        assertEquals(expectedApartmentId6.getWaterConsumption(),
                actualListOwnerId10005.get(2).getWaterConsumption());
        assertEquals(expectedApartmentId6.getHeaterConsumption(),
                actualListOwnerId10005.get(2).getHeaterConsumption());
        assertEquals(expectedApartmentId6.getLiabilities(),
                actualListOwnerId10005.get(2).getLiabilities());
        assertEquals(expectedApartmentId6.getNotes(),
                actualListOwnerId10005.get(2).getNotes());
    }

    @Test
    public void testGetOwnerNonExistingApartments() {
        List<Apartment> actualListOwnerId10005 =  service.getOwnerApartments(10146);
        assertEquals(0, actualListOwnerId10005.size());
    }

    @Test
    public void testGetAllApartments() {
        Apartment expectedApartmentId5 = new Apartment();
        expectedApartmentId5.setArea(BigDecimal.valueOf(55.00)
                .setScale(2, RoundingMode.UNNECESSARY));
        expectedApartmentId5.setNumberOfRooms(3);
        expectedApartmentId5.setNumberOfOccupants(2);
        expectedApartmentId5.setWaterConsumption(BigDecimal.valueOf(55.18));
        expectedApartmentId5.setHeaterConsumption(BigDecimal.valueOf(428.21));
        expectedApartmentId5.setLiabilities(BigDecimal.valueOf(0)
                .setScale(2, RoundingMode.UNNECESSARY));
        expectedApartmentId5.setNotes("Restoration in progress.");

        List<Apartment> actualList =  service.getAllApartments();

        assertEquals(6, actualList.size());

        assertEquals(expectedApartmentId5.getArea(),
                actualList.get(5).getArea());
        assertEquals(expectedApartmentId5.getNumberOfRooms(),
                actualList.get(5).getNumberOfRooms());
        assertEquals(expectedApartmentId5.getNumberOfOccupants(),
                actualList.get(5).getNumberOfOccupants());
        assertEquals(expectedApartmentId5.getWaterConsumption(),
                actualList.get(5).getWaterConsumption());
        assertEquals(expectedApartmentId5.getHeaterConsumption(),
                actualList.get(5).getHeaterConsumption());
        assertEquals(expectedApartmentId5.getLiabilities(),
                actualList.get(5).getLiabilities());
        assertEquals(expectedApartmentId5.getNotes(),
                actualList.get(5).getNotes());
    }
}