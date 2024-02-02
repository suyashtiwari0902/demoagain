package com.example.demo;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FutureDateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface FutureDate {
    String message() default "Due date must be in the future";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}