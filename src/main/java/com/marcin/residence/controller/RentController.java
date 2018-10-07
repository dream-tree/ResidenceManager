package com.marcin.residence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marcin.residence.service.RentService;

/**
 * Handles incoming requests for updating the Rent entities.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Controller
@RequestMapping("/residence")
public class RentController {

	@Autowired
	private RentService rentService;
	
	@GetMapping("/calculateRent")
	public void calculateRent() {
		rentService.calculateAllRents();
	}
}
