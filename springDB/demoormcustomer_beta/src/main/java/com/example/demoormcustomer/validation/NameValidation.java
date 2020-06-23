package com.example.demoormcustomer.validation;

import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidatorContext;

public class NameValidation implements ConstraintValidator<FirstNameValid, String> {


    @Override
    public void initialize(FirstNameValid contactNumber) {
    }

    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches("[a-zA-Z]+")
                && (contactField.length() > 2) && (contactField.length() < 7);
    }


}