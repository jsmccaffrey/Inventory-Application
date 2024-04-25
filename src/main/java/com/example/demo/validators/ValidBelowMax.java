package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BelowMaxValidator.class)
public @interface ValidBelowMax {
    String message() default "Inventory value must be less than or equal to Max";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
