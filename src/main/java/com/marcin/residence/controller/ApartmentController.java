package com.marcin.residence.controller;

import java.math.BigDecimal;
import java.util.List;

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

import com.marcin.residence.account.clearance.BankAccountTransactions;
import com.marcin.residence.account.clearance.BankAccountTransactionsService;
import com.marcin.residence.account.clearance.ResidenceLiabilities;
import com.marcin.residence.account.clearance.ResidenceLiabilitiesService;
import com.marcin.residence.entity.Apartment;
import com.marcin.residence.entity.ApartmentAddress;
import com.marcin.residence.entity.Owner;
import com.marcin.residence.entity.Rent;
import com.marcin.residence.service.ApartmentAddressService;
import com.marcin.residence.service.ApartmentService;
import com.marcin.residence.service.OwnerService;
import com.marcin.residence.service.RentService;

/**
 * Handles incoming requests, user input and interactions for creating,
 * reading, updating and deleting the Apartment objects as well as displaying
 * the requested Apartment content in a web page.
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
    @Autowired
    private ApartmentAddressService apartmentAddressService;
    @Autowired
    private BankAccountTransactionsService bankAccountTransactionsService;
    @Autowired
    private RentService rentService;
    @Autowired
    private ResidenceLiabilitiesService residenceLiabilitiesService;

	@GetMapping("/addApartment")
	public String addApartment(@RequestParam("ownerId") int theOwnerId, Model theModel) {
		Apartment theApartment = new Apartment();
		Owner theOwner = ownerService.getOwner(theOwnerId);
		theApartment.setOwner(theOwner);
		theModel.addAttribute("apartment", theApartment);
		return "apartment-update-form";
	}

	@GetMapping("/updateApartmentDetails")
	public String updateApartmentDetails(@RequestParam("apartmentId") int theApartmentId,
	        Model theModel) {
		Apartment theApartment = apartmentService.getSingleApartment(theApartmentId);
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
		int theOwnerId = theApartment.getOwner().getId();
		return "redirect:/residence/showDetails?ownerId=" + theOwnerId;
	}

	@GetMapping("/updateApartmentAddress")
	public String updateApartmentAddress(@RequestParam("apartmentId") int theApartmentId,
	        @RequestParam("ownerId") int theOwnerId, Model theModel) {
		ApartmentAddress theApartmentAddress =
		        apartmentAddressService.getApartmentAddress(theApartmentId);
		theModel.addAttribute("apartmentAddress", theApartmentAddress);
		theModel.addAttribute("ownerId", theOwnerId);
		return "apartment-address-update-form";
	}

	@PostMapping("/saveApartmentAddress")
	public String saveApartmentAddress(
	        @Valid @ModelAttribute("apartmentAddress") ApartmentAddress theApartmentAddress,
	        @RequestParam("ownerId") int theOwnerId,
	        BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "apartment-address-update-form";
		}
		apartmentAddressService.saveApartmentAddress(theApartmentAddress);
		return "redirect:/residence/showDetails?ownerId=" + theOwnerId;
	}

	@GetMapping("/deleteApartment")
	public String deleteApartment(@RequestParam("apartmentId") int theApartmentId,
			@RequestParam("ownerId") int theOwnerId, Model theModel) {
		apartmentService.deleteApartment(theApartmentId);
		return "redirect:/residence/showDetails?ownerId=" + theOwnerId;
	}

    @GetMapping("/showApartmentTransactions")
    public String showApartmentTransactions(@RequestParam("apartmentId") int theApartmentId,
            @RequestParam("ownerId") int theOwnerId, Model theModel) {
        List<BankAccountTransactions> theTransactionList = bankAccountTransactionsService
                .getTransactions(theApartmentId);
        theModel.addAttribute("transactionList", theTransactionList);
        theModel.addAttribute("ownerId", theOwnerId);
        return "transactions";
    }

    @GetMapping("/showRentDetails")
    public String showRentDetails(@RequestParam("apartmentId") int theApartmentId,
            @RequestParam("ownerId") int theOwnerId, Model theModel) {
        Rent theRent = rentService.getRent(theApartmentId);
        theModel.addAttribute("rent", theRent);
        theModel.addAttribute("ownerId", theOwnerId);
        return "rent-details";
    }

    @GetMapping("/showLiabilities")
    public String showLiabilities(@RequestParam("apartmentId") int theApartmentId,
            @RequestParam("ownerId") int theOwnerId, Model theModel) {
        List<ResidenceLiabilities> theLiabilityList =
                residenceLiabilitiesService.getLiabilities(theApartmentId);
        theModel.addAttribute("liabilityList", theLiabilityList);
        theModel.addAttribute("ownerId", theOwnerId);
        BigDecimal currentTotalLiabilitiesValue = 
                theLiabilityList.get(theLiabilityList.size() - 1).getTotalLiabilitiesValue();
        theModel.addAttribute("totalLiabilitiesValue", currentTotalLiabilitiesValue);
        return "liabilities-details";
    }
}