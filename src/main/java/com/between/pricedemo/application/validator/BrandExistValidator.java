package com.between.pricedemo.application.validator;

import com.between.pricedemo.domain.repository.BrandRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandExistValidator implements ConstraintValidator<BrandExist, Long> {

    private final BrandRepository brandRepository;

    @Override
    public boolean isValid(Long productId, ConstraintValidatorContext context) {
        return this.brandRepository.exist(productId);
    }

}