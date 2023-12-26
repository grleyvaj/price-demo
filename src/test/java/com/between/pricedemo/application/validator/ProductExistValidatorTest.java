package com.between.pricedemo.application.validator;

import com.between.pricedemo.domain.repository.ProductRepository;
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
class ProductExistValidatorTest {

    @InjectMocks
    private ProductExistValidator validator;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;

    @Test
    void when_product_is_given_then_its_searched() {
        assertFalse(this.validator.isValid(2L, this.constraintValidatorContext));

        verify(this.productRepository).exist(2L);
    }

    @Test
    void when_product_is_not_found_then_its_invalid() {
        when(this.productRepository.exist(anyLong())).thenReturn(Boolean.FALSE);

        assertFalse(this.validator.isValid(2L, this.constraintValidatorContext));
    }

    @Test
    void when_product_is_found_then_its_valid() {
        when(this.productRepository.exist(anyLong())).thenReturn(Boolean.TRUE);

        assertTrue(this.validator.isValid(2L, this.constraintValidatorContext));
    }

}