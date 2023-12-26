package com.between.pricedemo.domain.use_case.brand.create;

import com.between.pricedemo.domain.entity.Brand;
import com.between.pricedemo.domain.exception.ResourceCreateException;
import com.between.pricedemo.domain.repository.BrandCreateInput;
import com.between.pricedemo.domain.repository.BrandRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandCreateUseCase {

    private final BrandRepository brandRepository;

    public Brand execute(BrandCreateInput brandCreateInput) throws ResourceCreateException {
        return this.brandRepository.create(brandCreateInput);
    }

}
