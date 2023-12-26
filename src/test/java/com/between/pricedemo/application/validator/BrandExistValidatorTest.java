package com.between.pricedemo.application.validator;

import com.between.pricedemo.domain.repository.BrandRepository;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandExistValidatorTest {

    @InjectMocks
    private BrandExistValidator validator;

    @Mock
    private BrandRepository brandRepository;

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @Test
    void when_brand_is_given_then_its_searched() {
        assertFalse(this.validator.isValid(2L, this.constraintValidatorContext));

        verify(this.brandRepository).exist(2L);
    }

    @Test
    void when_brand_is_not_found_then_its_invalid() {
        when(this.brandRepository.exist(anyLong())).thenReturn(Boolean.FALSE);

        assertFalse(this.validator.isValid(2L, this.constraintValidatorContext));
    }

    @Test
    void when_brand_is_found_then_its_valid() {
        when(this.brandRepository.exist(anyLong())).thenReturn(Boolean.TRUE);

        assertTrue(this.validator.isValid(2L, this.constraintValidatorContext));
    }

}