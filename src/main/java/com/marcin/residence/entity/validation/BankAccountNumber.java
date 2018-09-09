package com.marcin.residence.entity.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy=BankAccountNumberConstraintValidator.class)       
@Target(ElementType.FIELD)                   
@Retention(RetentionPolicy.RUNTIME)          
public @interface BankAccountNumber    {

    public String value() default "";                                         

    public String message() default "{custom.bankAccountNumber}";    

    public Class<?>[] groups() default {};    

    public Class<? extends Payload>[] payload() default {};     
}  
