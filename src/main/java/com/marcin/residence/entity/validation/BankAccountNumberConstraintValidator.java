package com.marcin.residence.entity.validation;

import java.math.BigInteger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BankAccountNumberConstraintValidator implements ConstraintValidator<BankAccountNumber, String> {

    private String validNumber;                        
	
    @Override                                                                           
    public void initialize(BankAccountNumber bankAccountNumber) {
    	validNumber = bankAccountNumber.value();       
    } 

    @Override                            
    public boolean isValid(String theNumber, ConstraintValidatorContext theConstraintValidatorContext) {        	
    	if (theNumber == null) {
    		return true;
    	}    	
    	if(theNumber.length()!=26) {
    		return false;
    	} else { 
    		return validateNumber(theNumber);
    	}
    }
    
    public boolean validateNumber(String theNumber) {
    	int countryCode = 2521;
    	String checkSum = theNumber.substring(0, 2);
    	String numberWithoutCheckSum = theNumber.substring(2);
    	String rearrangedNumber = numberWithoutCheckSum + countryCode + checkSum;
    	BigInteger rearrangedNumberForValidation = new BigInteger(rearrangedNumber);
    	int check = rearrangedNumberForValidation.mod(new BigInteger("97")).intValue();   
    	if(check==1) {
    		return true;
    	} else {
    		return false;
    	}
    }	
}
