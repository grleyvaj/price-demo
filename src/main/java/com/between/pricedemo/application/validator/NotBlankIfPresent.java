package com.between.pricedemo.application.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = NotBlankIfPresentValidator.class)
@Target({FIELD, METHOD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface NotBlankIfPresent {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}