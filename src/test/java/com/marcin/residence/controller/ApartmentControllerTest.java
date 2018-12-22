package com.marcin.residence.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.service.ApartmentAddressService;
import com.marcin.residence.service.ApartmentService;
import com.marcin.residence.service.OwnerService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { DispatcherServletInitializer.class, AppConfig.class })
public class ApartmentControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Mock
    private OwnerService ownerService;
    @Mock
    private ApartmentService apartmentService;
    @Mock
    private ApartmentAddressService apartmentAddressService;
    @InjectMocks
    private ApartmentController controller;

    @Mock
    private Model model;
    @Mock
    private BindingResult theBindingResult;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddApartment() throws Exception {
        mockMvc
        .perform(get("/apartment/addApartment", model).param("ownerId", "1"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("apartment-update-form"))
        .andReturn();
    }

    @Test
    public void testUpdateApartmentDetails() throws Exception {
        mockMvc
        .perform(get("/apartment/updateApartmentDetails", model).param("apartmentId", "1"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("apartment-update-form"))
        .andReturn();
    }

    @Test
    public void testUpdateApartmentAddress() throws Exception {
        when(apartmentAddressService.getApartmentAddress(any(Integer.class)))
                .thenReturn(new ApartmentAddress());
        mockMvc
        .perform(get("/apartment/updateApartmentAddress", model)
                .param("apartmentId", "1")
                .param("ownerId", "10001"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("apartment-address-update-form"))
        .andReturn();
    }

    @Test 
    public void testDeleteApartment() throws Exception {
        doNothing().when(apartmentService).deleteApartment(any(Integer.class));
        mockMvc
        .perform(get("/apartment/deleteApartment", model)
                .param("apartmentId", "1")
                .param("ownerId", "1"))
        .andExpect(status().is(302))
        .andReturn();
    }
}