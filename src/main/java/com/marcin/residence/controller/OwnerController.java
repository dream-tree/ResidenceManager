package com.marcin.residence.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.Owner;
import com.marcin.residence.service.ApartmentService;
import com.marcin.residence.service.OwnerService;

@Controller
@RequestMapping("/residence")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	@Autowired
	private ApartmentService apartmentService;
	
	@GetMapping("/start")
	public String start(Model theModel) {			
		return "main-page";
	}
	
	@GetMapping("/list")
	public String listOwners(Model theModel) {		
		List<Owner> theOwners = ownerService.getOwners();
		theModel.addAttribute("owners", theOwners);		
		return "owner-list";
	}
	
	 @PostMapping("/search")
	 public String searchOwners(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		 List<Owner> theOwners = ownerService.searchOwners(theSearchName);
		 theModel.addAttribute("owners", theOwners);
		 return "owner-list";
	 }
	
	 @GetMapping("/showDetails")
	 public String showDetails(@RequestParam("ownerId") int theId, Model theModel) {
		 Owner theOwner = ownerService.getOwner(theId);
		 List<Apartment> theApartments = apartmentService.getApartments(theId);
		 theModel.addAttribute("owner", theOwner);
		 theModel.addAttribute("apartments", theApartments);
		 return "detailed-owner-list";
	 } 
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Owner theOwner = new Owner();
		theModel.addAttribute("owner", theOwner);
		return "owner-update-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ownerId") int theId, Model theModel) {
		Owner theOwner = ownerService.getOwner(theId);
		theModel.addAttribute("owner", theOwner);
		return "owner-update-form";
	}
	
	@PostMapping("/saveOwner")
	public String saveOwner(@Valid @ModelAttribute("owner") Owner theOwner,
			BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			return "owner-update-form";
		}
		ownerService.saveOwner(theOwner);		
		int theId = theOwner.getId();
		return "redirect:/residence/showDetails?ownerId="+theId;
	}
	
	@GetMapping("/deleteOwner")
	public String deleteOwner(@RequestParam("ownerId") int theId) {
		ownerService.deleteOwner(theId);
		return "redirect:/residence/list";
	}
	  
	 @InitBinder                                                                             
	 public void initBinder(WebDataBinder dataBinder) {
	      StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);   
	      dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);                
	 }
}
