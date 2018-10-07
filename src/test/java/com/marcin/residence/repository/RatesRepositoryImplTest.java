package com.marcin.residence.repository;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

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
import com.marcin.residence.entity.Rates;
import com.marcin.residence.service.OwnerService;
import com.marcin.residence.service.RatesService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={DispatcherServletInitializer.class, AppConfig.class})
public class RatesRepositoryImplTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private RatesService service;
	
	@Test
	public void testGetGetRates() {		
		Rates actualOwnerRates = service.getRates();

		assertEquals(BigDecimal.valueOf(2.14), actualOwnerRates.getRepairFundRate());
		assertEquals(BigDecimal.valueOf(4.35), actualOwnerRates.getWaterRate());
		assertEquals(BigDecimal.valueOf(3.90).setScale(2, RoundingMode.UNNECESSARY), actualOwnerRates.getHeatingRate());
		assertEquals(BigDecimal.valueOf(5.50).setScale(2, RoundingMode.UNNECESSARY), actualOwnerRates.getWasteFee());
		assertEquals(BigDecimal.valueOf(8.00).setScale(2, RoundingMode.UNNECESSARY), actualOwnerRates.getTvFee());
	}
}
