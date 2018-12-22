package com.marcin.residence.account.balance;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.marcin.residence.config.AppConfig;
import com.marcin.residence.config.DispatcherServletInitializer;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DispatcherServletInitializer.class, AppConfig.class })
public class ApartmentAccountBalanceRepositoryImplTestGetBalance {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ApartmentAccountBalanceService balanceService;
    
    @Test
    public void getApartmentAccountBalanceShouldReturnValue() {
        ApartmentAccountBalance actualBalance = balanceService.getApartmentAccountBalance(1);
        assertEquals(BigDecimal.valueOf(-3).setScale(2),
                actualBalance.getTotalLiabilitiesValue());
    }
    
    @Test
    public void getApartmentAccountBalanceShouldReturnDefaultDateTime() {
        ApartmentAccountBalance actualBalance = balanceService.getApartmentAccountBalance(2);
        assertEquals(LocalDateTime.of(1970, 01, 01, 01, 00),
                actualBalance.getCalculationDate());   
    }  
}
