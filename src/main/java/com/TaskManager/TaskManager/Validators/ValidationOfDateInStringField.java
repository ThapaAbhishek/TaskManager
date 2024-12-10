package com.TaskManager.TaskManager.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidationOfDateInStringField implements ConstraintValidator<ValidateDateInString, String> {
    @Override
    public void initialize(ValidateDateInString constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (value == null || value.isEmpty()) {
            return false; // Invalid if null or empty
        }
       return value.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");

    }
}
