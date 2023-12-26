package com.between.pricedemo.infrastructure.repository;

import com.between.pricedemo.domain.entity.Brand;
import com.between.pricedemo.domain.exception.ResourceCreateException;
import com.between.pricedemo.domain.repository.BrandCreateInput;
import com.between.pricedemo.domain.repository.BrandRepository;

public class CustomBrandRepository implements BrandRepository {

    @Override
    public Brand create(BrandCreateInput input) throws ResourceCreateException {
        return null;
    }

    @Override
    public boolean exist(Long brandId) {
        return false;
    }

}
