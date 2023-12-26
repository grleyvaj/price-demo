package com.between.pricedemo.application.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class NotBlankIfPresentValidator implements ConstraintValidator<NotBlankIfPresent, String> {

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        if (isNull(field)) {
            return true;
        }

        return !field.isBlank();
    }

}