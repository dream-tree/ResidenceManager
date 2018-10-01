package com.marcin.residence.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles interactions for logging to the application.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Controller
public class LoginController {

	@GetMapping("/showLoginPage")
	public String showLoginPage() {		
		return "login-page";		
	}
}
