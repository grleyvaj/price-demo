package com.between.pricedemo.application.validator;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class NotBlankIfPresentValidatorTest {

    @InjectMocks
    private NotBlankIfPresentValidator validator;

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @Test
    void when_element_is_not_given_then_its_valid() {
        assertTrue(this.validator.isValid(null, this.constraintValidatorContext));
    }

    @Test
    void when_element_is_blank_then_its_invalid() {
        assertFalse(this.validator.isValid("  ", this.constraintValidatorContext));
    }

    @Test
    void when_element_is_empty_then_its_invalid() {
        assertFalse(this.validator.isValid("", this.constraintValidatorContext));
    }

    @Test
    void when_element_is_not_empty_and_not_blank_then_its_valid() {
        assertTrue(this.validator.isValid("::any::", this.constraintValidatorContext));
    }

}