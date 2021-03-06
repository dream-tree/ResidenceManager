package com.marcin.residence.account.balance;

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

import com.marcin.residence.config.AppConfig;
import com.marcin.residence.config.DispatcherServletInitializer;
import com.marcin.residence.entity.Rent;
import com.marcin.residence.service.RentService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DispatcherServletInitializer.class, AppConfig.class })
public class ApartmentAccountBalanceRepositoryImplIncreaseBalance {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ApartmentAccountBalanceService balanceService;
    @Autowired
    private RentService rentService;

    @Test
    public void testIncreaseApartmentAccountBalance() {
        List<ApartmentAccountBalance> beforeIncrementBalanceList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            ApartmentAccountBalance currentBalance = balanceService.getApartmentAccountBalance(i);
            beforeIncrementBalanceList.add(currentBalance);
        }
        
        List<Rent> rentList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Rent rent = new Rent();
            rent.setId(i);
            rent.setMonthlyTotalRent(BigDecimal.valueOf(20.00));
            rentList.add(rent);
        }
        
        balanceService.increaseApartmentAccountBalance(rentList);

        for (int i = 1; i < 4; i++) {
            ApartmentAccountBalance actualBalance = balanceService.getApartmentAccountBalance(i);
            BigDecimal actualTotalLiabilitiesValue = actualBalance.getTotalLiabilitiesValue();
            BigDecimal beforeIncrementTotalLiabilitiesValue =
                    beforeIncrementBalanceList.get(i-1).getTotalLiabilitiesValue();
            BigDecimal expectedTotalLiabilitiesValue =
                    BigDecimal.valueOf(20.00).add(beforeIncrementTotalLiabilitiesValue);
            
            assertEquals(expectedTotalLiabilitiesValue, actualTotalLiabilitiesValue);
        }
    }
}
