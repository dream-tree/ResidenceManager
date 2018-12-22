package com.marcin.residence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marcin.residence.service.RentService;

/**
 * Handles incoming requests for updating the rent value.
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
@Controller
@RequestMapping("/residence")
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("/calculateRent")
    public String calculateRent() {
        rentService.calculateAllRents();
        return "rent-calculation-result";
    }
}
