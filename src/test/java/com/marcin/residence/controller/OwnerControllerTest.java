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
import com.marcin.residence.entity.Owner;
import com.marcin.residence.service.ApartmentService;
import com.marcin.residence.service.OwnerService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={DispatcherServletInitializer.class, AppConfig.class})
public class OwnerControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    
	@Mock
	private OwnerService ownerService;
	@Mock
	private ApartmentService apartmentService; 
	@InjectMocks
	private OwnerController controller;	

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
	public void testStart() throws Exception {
		mockMvc.perform(get("/residence/start", model))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("main-page"))	
			.andReturn();	
	}

	@Test
	public void testListOwners() throws Exception {
		mockMvc
			.perform(get("/residence/list", model))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("owner-list"))
			.andReturn();
	}

	@Test
	public void testSearchOwners() throws Exception {
		mockMvc
			.perform(post("/residence/search", model).param("theSearchName", "theSearchName"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("owner-list"))
			.andReturn();
	}
	
	@Test
	public void testShowDetails() throws Exception {		
		mockMvc
			.perform(get("/residence/showDetails", model).param("ownerId", "1"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("detailed-owner-list"))
			.andReturn();
	}
	
	@Test
	public void testShowFormForAdd() throws Exception {
		mockMvc
			.perform(get("/residence/showFormForAdd", model))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("owner-update-form"))
			.andReturn();
	}

	@Test
	public void testShowFormForUpdate() throws Exception {		
		Owner mockOwner = new Owner();
		mockMvc
			.perform(get("/residence/showFormForUpdate", model).param("ownerId", "1"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("owner-update-form"))
			.andReturn();
	}

	@Test
	public void testSaveOwner() throws Exception {		
		Owner mockOwner = new Owner();		
		mockMvc
			.perform(post("/residence/saveOwner", mockOwner, theBindingResult))
			.andExpect(status().is(302))
			.andReturn();		
	}

	@Test
	public void testDeleteOwner() throws Exception {				
		mockMvc
			.perform(get("/residence/deleteOwner").param("ownerId", "1"))
			.andExpect(status().is(302))
			.andReturn();		
	}
}