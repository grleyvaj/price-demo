package com.between.pricedemo.application.validator;

import com.between.pricedemo.domain.repository.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductExistValidator implements ConstraintValidator<ProductExist, Long> {

    private final ProductRepository productRepository;

    @Override
    public boolean isValid(Long productId, ConstraintValidatorContext context) {
        return this.productRepository.exist(productId);
    }

}