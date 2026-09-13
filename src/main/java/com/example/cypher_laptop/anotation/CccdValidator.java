package com.example.cypher_laptop.anotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CccdValidator implements ConstraintValidator<Cccd, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null || value.isBlank()) {
            return true;
        }

        return value.matches("^0(0[1-9]|[1-9]\\d)[0-3]\\d{2}\\d{6}$");
    }
}
