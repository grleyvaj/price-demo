package com.between.pricedemo.domain.repository;

import com.between.pricedemo.domain.entity.Brand;
import com.between.pricedemo.domain.exception.ResourceCreateException;

public interface BrandRepository {

    Brand create(BrandCreateInput input) throws ResourceCreateException;

    boolean exist(Long brandId);

}
