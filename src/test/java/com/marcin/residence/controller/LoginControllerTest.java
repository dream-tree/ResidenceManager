package com.marcin.residence.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
//import static org.mockito.ArgumentMatchers.any;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.marcin.residence.config.AppConfig;
import com.marcin.residence.config.DispatcherServletInitializer;
import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.Owner;
import com.marcin.residence.repository.OwnerRepository;
import com.marcin.residence.service.ApartmentService;
import com.marcin.residence.service.OwnerService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={DispatcherServletInitializer.class, AppConfig.class})
public class LoginControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
	@Autowired
	private LoginController controller;	
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testStart() throws Exception {
		mockMvc.perform(get("/showLoginPage"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("login-page"))	
			.andReturn();	
	}
}