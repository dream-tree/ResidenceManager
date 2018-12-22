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

import com.marcin.residence.account.transaction.ApartmentAccountBankTransaction;
import com.marcin.residence.config.AppConfig;
import com.marcin.residence.config.DispatcherServletInitializer;
import com.marcin.residence.entity.Apartment;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DispatcherServletInitializer.class, AppConfig.class })
public class ApartmentAccountBalanceRepositoryImplDecreaseBalance {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ApartmentAccountBalanceService balanceService;

    @Test
    public void testIncreaseApartmentAccountBalance() {
        List<ApartmentAccountBalance> beforeIncrementBalanceList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            ApartmentAccountBalance currentBalance = balanceService.getApartmentAccountBalance(i);
            beforeIncrementBalanceList.add(currentBalance);
        }
        
        List<ApartmentAccountBankTransaction> transactionList = new ArrayList<>();  
        for (int i = 1; i < 4; i++) {
            ApartmentAccountBankTransaction transaction = new ApartmentAccountBankTransaction();
            Apartment mockApartment = new Apartment();
            mockApartment.setId(i);
            transaction.setApartment(mockApartment);
            transaction.setTransactionId("08PG-5W3A-64SD-" + i + "K4B");
            transaction.setTransactionFlag(false);
            transaction.setTransactionAmount(BigDecimal.valueOf(20.00));
            transactionList.add(transaction);
        }

        balanceService.decreaseApartmentAccountBalance(transactionList);

        for (int i = 1; i < 4; i++) {
            ApartmentAccountBalance actualBalance = balanceService.getApartmentAccountBalance(i);
            BigDecimal actualTotalLiabilitiesValue = actualBalance.getTotalLiabilitiesValue();
            BigDecimal beforeIncrementTotalLiabilitiesValue =
                    beforeIncrementBalanceList.get(i-1).getTotalLiabilitiesValue();
            BigDecimal expectedTotalLiabilitiesValue =
                    beforeIncrementTotalLiabilitiesValue.subtract(BigDecimal.valueOf(20.00));
            
            assertEquals(expectedTotalLiabilitiesValue, actualTotalLiabilitiesValue);
        }
    }
}
