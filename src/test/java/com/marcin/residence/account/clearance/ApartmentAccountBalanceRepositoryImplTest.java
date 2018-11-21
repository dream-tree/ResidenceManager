package com.marcin.residence.account.clearance;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.marcin.residence.account.balance.ApartmentAccountBalance;
import com.marcin.residence.account.balance.ApartmentAccountBalanceService;
import com.marcin.residence.config.AppConfig;
import com.marcin.residence.config.DispatcherServletInitializer;
import com.marcin.residence.entity.Rent;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DispatcherServletInitializer.class, AppConfig.class })
public class ApartmentAccountBalanceRepositoryImplTest {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ApartmentAccountBalanceService service;

    @Test
    public void testGetApartmentAccountBalance() {
        ApartmentAccountBalance actualBalance = service.getApartmentAccountBalance(1);
        assertEquals(BigDecimal.valueOf(20.50).setScale(2),
                actualBalance.getTotalLiabilitiesValue());
    }

    @Test
    public void testUpdateApartmentAccountBalance() {
        List<Rent> rentList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Rent rent = new Rent();
            rent.setId(i + 1);
            rent.setMonthlyTotalRent(BigDecimal.valueOf(20.50)
                    .multiply(BigDecimal.valueOf(i + 1)));
            rentList.add(rent);
        }

        service.updateApartmentAccountBalance(rentList);

        for (int i = 0; i < 7; i++) {
            ApartmentAccountBalance actualBalance = service.getApartmentAccountBalance(i + 1);
            assertEquals(BigDecimal.valueOf(20.50).multiply(BigDecimal.valueOf(i+1)).setScale(2),
                    actualBalance.getTotalLiabilitiesValue());
        }
    }
}
