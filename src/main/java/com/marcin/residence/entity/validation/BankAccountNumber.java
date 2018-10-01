package com.marcin.residence.entity.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The annotated element must be a 26-digit number and must include 2 (matching) control digits.
 * 
 * @author dream-tree
 * @version 4.00, September-October 2018
 */
@Constraint(validatedBy=BankAccountNumberConstraintValidator.class)       
@Target(ElementType.FIELD)                   
@Retention(RetentionPolicy.RUNTIME)          
public @interface BankAccountNumber    {

    public String value() default "";                                         

    public String message() default "{custom.bankAccountNumber}";    

    public Class<?>[] groups() default {};    

    public Class<? extends Payload>[] payload() default {};     
}  
