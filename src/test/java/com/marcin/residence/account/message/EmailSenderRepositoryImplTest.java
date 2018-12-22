package com.marcin.residence.account.message;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

import com.marcin.residence.config.AppConfig;
import com.marcin.residence.config.DispatcherServletInitializer;
import com.marcin.residence.controller.ApartmentController;
import com.marcin.residence.service.ApartmentService;
import com.marcin.residence.service.OwnerService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DispatcherServletInitializer.class, AppConfig.class })
public class EmailSenderRepositoryImplTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private EmailService service;

    @Test
    public void shouldGetCorrectEmaillAddress() {
        Map<Integer, BigDecimal> apartmentsWithOverdraft = new HashMap<>();
        Map<Integer, String> apartmentsWithEmail = new HashMap<>();
        apartmentsWithOverdraft.put(1, BigDecimal.valueOf(30.50));
        apartmentsWithOverdraft.put(7, BigDecimal.valueOf(30.50));
        apartmentsWithEmail = service.getEmailAddresses(apartmentsWithOverdraft);
        apartmentsWithEmail.forEach((key, value) ->
                                System.out.println(key + ", " + value));
        assertEquals(apartmentsWithEmail.get(1), "david@aol.com");
        assertEquals(apartmentsWithEmail.get(7), "max@yandex.ru");
    }
}
