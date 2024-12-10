package com.TaskManager.TaskManager.Validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidationOfDateInStringField.class) // Link to the validator class
@Target({ElementType.FIELD, ElementType.PARAMETER}) // Applicable to fields and method parameters
@Retention(RetentionPolicy.RUNTIME) // Retain at runtime
public @interface ValidateDateInString {

    String message() default "Insert a valid date in YYYY-mm-dd format"; // Default error message

    Class<?>[] groups() default {}; // Grouping constraints

    Class<? extends Payload>[] payload() default {}; // Additional metadata
}

