package com.marcin.residence.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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