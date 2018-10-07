package com.marcin.residence.repository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
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
import com.marcin.residence.entity.Owner;
import com.marcin.residence.entity.OwnerMailingAddress;
import com.marcin.residence.service.OwnerService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={DispatcherServletInitializer.class, AppConfig.class})
public class OwnerRepositoryImplTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private OwnerService service;
	
	@Test
	public void testGetOwner() {		
		Owner actualOwner =  service.getOwner(10002);
		OwnerMailingAddress actualOwnerMailingAddress = actualOwner.getOwnerMailingAddress();

		assertEquals("John", actualOwner.getFirstName());
		assertEquals("Doherty", actualOwner.getLastName());
		assertEquals("785126856", actualOwner.getPhoneNumber());
		assertEquals("john@yahoo.com", actualOwner.getEmail());
		assertEquals(LocalDate.of(1994, 11, 03), actualOwner.getDateOfBirth());
		assertEquals("94110385691", actualOwner.getPesel());
		assertEquals("21105014150000158448795952", actualOwner.getBankAccount());
		
		assertEquals("Warowna", actualOwnerMailingAddress.getStreet());
		assertEquals("21/6", actualOwnerMailingAddress.getApartmentNumber());
		assertEquals("Pszczyna", actualOwnerMailingAddress.getCity());
		assertEquals("43-200", actualOwnerMailingAddress.getPostalCode());		
	}
	
	@Test(expected=NoResultException.class)
	public void testGetNonExistingOwner() {		
		service.getOwner(10524);
	}
	
	@Test
	public void testGetOwners() {		
		List<Owner> actualOwners = service.getOwners();
		assertEquals(9, actualOwners.size());
		assertEquals("Altman", actualOwners.get(0).getLastName());
		assertEquals("Dixon", actualOwners.get(4).getLastName());
		assertEquals("Wilson", actualOwners.get(8).getLastName());
	}
	
	@Test
	public void testSearchOwnersByFirstName() {		
		List<Owner> actualOwners = service.searchOwners("Steven");
		assertEquals(2, actualOwners.size());
		assertEquals("Quist", actualOwners.get(0).getLastName());
		assertEquals("Wilson", actualOwners.get(1).getLastName());
	}
	
	@Test
	public void testSearchOwnersByFirstNameWithDiffCases() {		
		List<Owner> actualOwners = service.searchOwners("sTeVEN");
		assertEquals(2, actualOwners.size());
		assertEquals("Quist", actualOwners.get(0).getLastName());
		assertEquals("Wilson", actualOwners.get(1).getLastName());
	}
	
	@Test
	public void testSearchOwnersByLastName() {		
		List<Owner> actualOwners = service.searchOwners("Curdle");
		assertEquals(1, actualOwners.size());
		assertEquals("Darry", actualOwners.get(0).getFirstName());
	}
	
	@Test
	public void testSearchOwnersByPartOfName() {		
		List<Owner> actualOwners = service.searchOwners("rry");
		assertEquals(2, actualOwners.size());
		assertEquals("Darry", actualOwners.get(0).getFirstName());
		assertEquals("Ferrytale", actualOwners.get(1).getLastName());
	}
	
	@Test
	public void testSearchOwnersByPartOfNameWithDiffCases() {		
		List<Owner> actualOwners = service.searchOwners("mA");
		assertEquals(2, actualOwners.size());
		assertEquals("Altman", actualOwners.get(0).getLastName());
		assertEquals("Maxwell", actualOwners.get(1).getFirstName());
	}
	
	@Test
	public void testSearchOwnersWithEmptySearchStringGetsAllOwners() {		
		List<Owner> actualOwners = service.searchOwners("");
		assertEquals(9, actualOwners.size());
		assertEquals("Altman", actualOwners.get(0).getLastName());
		assertEquals("Dixon", actualOwners.get(4).getLastName());
		assertEquals("Wilson", actualOwners.get(8).getLastName());
	}
	
	@Test
	public void testGetOwnerMailingAddress() {		
		OwnerMailingAddress actualOwnerMailingAddress = service.getOwnerMailingAddress(10003);		
		assertEquals("Rymarska", actualOwnerMailingAddress.getStreet());
		assertEquals("34/1", actualOwnerMailingAddress.getApartmentNumber());
		assertEquals("Pszczyna", actualOwnerMailingAddress.getCity());
		assertEquals("43-200", actualOwnerMailingAddress.getPostalCode());	
	}
}
