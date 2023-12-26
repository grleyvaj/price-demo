package com.between.pricedemo.application.controller.brand.create.response;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.domain.entity.Brand;

public class BrandCreateResponseMapper implements Mapper<Brand, BrandCreateResponse> {

    @Override
    public BrandCreateResponse map(Brand model) {
        BrandCreateResponse response = new BrandCreateResponse(
                model.getId(),
                model.getName(),
                model.getCountryCode()
        );

        model.getSector().ifPresent(response::setSector);

        return response;
    }

}
