package com.example.demo.validators;

import com.example.demo.domain.Part;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BelowMaxValidator implements ConstraintValidator<ValidBelowMax, Part> {

    @Override
    public void initialize(ValidBelowMax constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        if (part.getInv() <= part.getMaxInv()) {
            return true;
        }
        return false;
    }
}

