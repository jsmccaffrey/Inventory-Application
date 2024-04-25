package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AboveMinValidator.class)
public @interface ValidAboveMin {
    String message() default "Inventory value must be greater than or equal to Min";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
