package com.marcin.residence.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.marcin.residence.config.AppConfig;
import com.marcin.residence.config.DispatcherServletInitializer;
import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.Rates;
import com.marcin.residence.entity.Rent;
import com.marcin.residence.repository.RentRepository;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={DispatcherServletInitializer.class, AppConfig.class})
public class RentServiceImplTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
	@Mock
	private RatesService ratesService;	
	@Mock
	private ApartmentService apartmentService;
	@Mock
	private RentRepository rentRepository;
	
	@InjectMocks
	private RentServiceImpl rentService;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(rentService).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCalculateAllRents() {	
		Rates theRates = new Rates();
		theRates.setRepairFundRate(BigDecimal.valueOf(2.00));
		theRates.setWaterRate(BigDecimal.valueOf(4.35));
		theRates.setHeatingRate(BigDecimal.valueOf(3.90));
		theRates.setWasteFee(BigDecimal.valueOf(5.50));
		theRates.setTvFee(BigDecimal.valueOf(8.00));
		
		List<Apartment> theApartments = new ArrayList<>();
		Apartment theApartment1 = new Apartment();
		theApartment1.setArea(BigDecimal.valueOf(61.80));
		theApartment1.setWaterConsumption(BigDecimal.valueOf(54.25));
		theApartment1.setHeaterConsumption(BigDecimal.valueOf(82.87));
		theApartment1.setNumberOfOccupants(3);
		theApartment1.setRent(new Rent());
		
		Apartment theApartment2 = new Apartment();
		theApartment2.setArea(BigDecimal.valueOf(58.20));
		theApartment2.setWaterConsumption(BigDecimal.valueOf(98.34));
		theApartment2.setHeaterConsumption(BigDecimal.valueOf(102.58));
		theApartment2.setNumberOfOccupants(5);
		theApartment2.setRent(new Rent());
		
		theApartments.add(theApartment1);
		theApartments.add(theApartment2);
		
		when(ratesService.getRates()).thenReturn(theRates);
		when(apartmentService.getAllApartments()).thenReturn(theApartments);
		doNothing().when(rentRepository).saveRent(any(Rent.class));
		
		rentService.calculateAllRents();

		assertEquals(BigDecimal.valueOf(123.60).setScale(2, RoundingMode.UNNECESSARY), 
				theApartment1.getRent().getRepairFundTotalCost());
		assertEquals(BigDecimal.valueOf(235.99), 
				theApartment1.getRent().getWaterTotalCost().setScale(2, RoundingMode.HALF_UP));
		assertEquals(BigDecimal.valueOf(323.19), 
				theApartment1.getRent().getHeatingTotalCost().setScale(2, RoundingMode.HALF_UP));
		assertEquals(BigDecimal.valueOf(16.50), 
				theApartment1.getRent().getWasteFeeTotalCost());
		assertEquals(BigDecimal.valueOf(8.00), 
				theApartment1.getRent().getTvFeeTotal());
		assertEquals(BigDecimal.valueOf(707.28), 
				theApartment1.getRent().getMonthlyTotalRent().setScale(2, RoundingMode.HALF_UP));
		
		assertEquals(BigDecimal.valueOf(116.40).setScale(2, RoundingMode.UNNECESSARY), 
				theApartment2.getRent().getRepairFundTotalCost());
		assertEquals(BigDecimal.valueOf(427.78), 
				theApartment2.getRent().getWaterTotalCost().setScale(2, RoundingMode.HALF_UP));
		assertEquals(BigDecimal.valueOf(400.06), 
				theApartment2.getRent().getHeatingTotalCost().setScale(2, RoundingMode.HALF_UP));
		assertEquals(BigDecimal.valueOf(27.50), 
				theApartment2.getRent().getWasteFeeTotalCost());
		assertEquals(BigDecimal.valueOf(8.00), 
				theApartment2.getRent().getTvFeeTotal());
		assertEquals(BigDecimal.valueOf(979.74), 
				theApartment2.getRent().getMonthlyTotalRent().setScale(2, RoundingMode.DOWN));		
	}
}
