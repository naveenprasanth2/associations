package com.bharath.springdata.associations.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidation implements ConstraintValidator<UniqueEmailValidator, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        if (email.contains("@")) {
            return true;
        }
        return email.contains(".");
    }
}
