package com.marcin.residence.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Initializes methods for data binding to be applied 
 * to the appropriate Controllers.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@ControllerAdvice(assignableTypes = {ApartmentController.class,
        OwnerController.class, RatesController.class})
public class GlobalBindingInitializer {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
