package com.marcin.residence.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.entity.Owner;
import com.marcin.residence.entity.OwnerMailingAddress;
import com.marcin.residence.service.ApartmentService;
import com.marcin.residence.service.OwnerService;

/**
 * Handles incoming requests, user input and interactions for creating, reading, updating
 * and deleting the Apartment objects as well as displaying the requested Apartment content 
 * in a web page.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Controller
@RequestMapping("/apartment")
public class ApartmentController {

	@Autowired
	private ApartmentService apartmentService;
	@Autowired
	private OwnerService ownerService;

	@GetMapping("/addApartment")
	public String addApartment(@RequestParam("ownerId") int theId, Model theModel) {
		Apartment theApartment = new Apartment();
		Owner theOwner = ownerService.getOwner(theId);
		theApartment.setOwner(theOwner);
		theModel.addAttribute("apartment", theApartment);
		return "apartment-update-form";
	}

	@GetMapping("/updateApartmentDetails")
	public String updateApartmentDetails(@RequestParam("apartmentId") int theId, Model theModel) {
		Apartment theApartment = apartmentService.getSingleApartment(theId);
		theModel.addAttribute("apartment", theApartment);
		return "apartment-update-form";
	}

	@PostMapping("/saveApartmentDetails")
	public String saveApartmentDetails(@Valid @ModelAttribute("apartment") Apartment theApartment,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "apartment-update-form";
		}
		apartmentService.saveApartment(theApartment);
		int id = theApartment.getOwner().getId();
		return "redirect:/residence/showDetails?ownerId=" + id;
	}

	@GetMapping("/updateApartmentAddress")
	public String updateApartmentAddress(@RequestParam("apartmentId") int theId, Model theModel) {
		ApartmentAddress theApartmentAddress = apartmentService.getSingleApartment(theId).getApartmentAddress();
		theModel.addAttribute("apartmentAddress", theApartmentAddress);
		return "apartment-address-update-form";
	}

	@PostMapping("/saveApartmentAddress")
	public String saveApartmentAddress(@Valid @ModelAttribute("apartmentAddress") ApartmentAddress theApartmentAddress,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "apartment-address-update-form";
		}
		apartmentService.saveApartmentAddress(theApartmentAddress);
		int theOwnerId = theApartmentAddress.getApartment().getOwner().getId();
		return "redirect:/residence/showDetails?ownerId=" + theOwnerId;
	}

	@GetMapping("/updateMailingAddress")
	public String updateMailingAddress(@RequestParam("ownerId") int theId, Model theModel) {
		OwnerMailingAddress theOwnerMailingAddress = ownerService.getOwner(theId).getOwnerMailingAddress();
		theModel.addAttribute("ownerMailingAddress", theOwnerMailingAddress);
		return "owner-mailing-address-form";
	}

	@PostMapping("/saveOwnerMailingAddress")
	public String saveOwnerMailingAddress(
			@Valid @ModelAttribute("ownerMailingAddress") OwnerMailingAddress ownerMailingAddress,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "owner-mailing-address-form";
		}
		ownerService.saveOwnerMailingAddress(ownerMailingAddress);
		int theOwnerId = ownerMailingAddress.getOwner().getId();
		return "redirect:/residence/showDetails?ownerId=" + theOwnerId;
	}

	@GetMapping("/deleteApartment")
	public String deleteApartment(@RequestParam("apartmentId") int theApartmentId,
			@RequestParam("ownerId") int theOwnerId, Model theModel) {
		apartmentService.deleteApartment(theApartmentId);
		return "redirect:/residence/showDetails?ownerId=" + theOwnerId;
	}
}
