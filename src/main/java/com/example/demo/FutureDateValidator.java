package com.example.demo;

import com.example.demo.FutureDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class FutureDateValidator implements ConstraintValidator<FutureDate, LocalDate> {
    @Override
    public void initialize(FutureDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Null values are considered valid, handle this according to your requirements
        }

        LocalDate currentDate = LocalDate.now();
        return value.isAfter(currentDate);
    }
}
