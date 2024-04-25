package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AboveMinValidator implements ConstraintValidator<ValidAboveMin, Part> {

    @Override
    public void initialize(ValidAboveMin constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        if (part.getInv() >= part.getMinInv()) {
            return true;
        }
        return false;
    }
}

