package com.marcin.residence.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.marcin.residence.service.RatesService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={DispatcherServletInitializer.class, AppConfig.class})
public class RatesControllerTest {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
    
	@Mock
	private RatesService ratesService;
	@InjectMocks
	private RatesController controller;	

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
	public void testShowRatesForm() throws Exception {
		mockMvc.perform(get("/residence/showRatesForm", model))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("rates-form"))	
			.andReturn();	
	}

	@Test
	public void testSaveRatesForm() throws Exception {
		mockMvc.perform(post("/residence/saveRatesForm", theBindingResult))
			.andExpect(status().is(302))
			.andReturn();	
	}
}
