package com.marcin.residence.controller;

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

import com.marcin.residence.entity.Rates;
import com.marcin.residence.service.RatesService;

/**
 * Handles incoming requests for updating the Rate entity 
 * as well as displaying the actual Rate details in a web page.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Controller
@RequestMapping("/residence")
public class RatesController {
	
	@Autowired 
	private RatesService ratesService;
	
	@GetMapping("/showRatesForm")
	public String showRatesForm(Model rates) {	
		Rates theRates = ratesService.getRates();	
		rates.addAttribute("rates", theRates);	
		return "rates-form";
	}
	
	@PostMapping("/saveRatesForm")
	public String saveRatesForm(@Valid @ModelAttribute("rates") Rates theRates, BindingResult thebindingResult) {	
		if(thebindingResult.hasErrors()) {
			return "rates-form";
		}
		ratesService.saveRates(theRates);		
		return "redirect:/residence/start";
	}
	
	 @InitBinder                                                                             
	 public void initBinder(WebDataBinder dataBinder) {
	      StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);   
	      dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);                
	 }
}
