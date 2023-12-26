package com.between.pricedemo.infrastructure.persistence.entity;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.domain.entity.Brand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandMapper implements Mapper<BrandEntity, Brand> {

    @Override
    public Brand map(BrandEntity entity) {
        return new Brand(
                entity.getId(),
                entity.getName(),
                entity.getCountryCode()
        ).setSector(entity.getSector());
    }

}
