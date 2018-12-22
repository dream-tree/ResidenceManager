package com.marcin.residence.entity.validation;

import java.math.BigInteger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Defines the logic to validate the {@link BankAccountNumber} for a given string.
 * The following format of the Bank Account Number is acceptable:
 * <ul>
 * <li>00 - control digits</li>
 * <li>11111111 - 8-digit bank branch number</li>
 * <li>2222222222222222 - 16-digit account number</li>
 * </ul>
 *
 * @author dream-tree
 * @version 5.00, September-December 2018
 */
public class BankAccountNumberConstraintValidator
        implements ConstraintValidator<BankAccountNumber, String> {

    private String validNumber;

    @Override
    public void initialize(BankAccountNumber bankAccountNumber) {
        validNumber = bankAccountNumber.value();
    }

    @Override
    public boolean isValid(String theNumber,
            ConstraintValidatorContext theConstraintValidatorContext) {
        if (theNumber == null) {
            return true;
        }
        return theNumber.length() != 26 ? false : validateNumber(theNumber);
    }

    public boolean validateNumber(String theNumber) {
        int countryCode = 2521;
        String checkSum = theNumber.substring(0, 2);
        String numberWithoutCheckSum = theNumber.substring(2);
        String rearrangedNumber = numberWithoutCheckSum + countryCode + checkSum;
        BigInteger rearrangedNumberForValidation = new BigInteger(rearrangedNumber);
        int check = rearrangedNumberForValidation.mod(new BigInteger("97")).intValue();
        return check == 1 ? true : false;
    }
}