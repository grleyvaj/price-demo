package com.between.pricedemo.application.controller.brand.create.request;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.domain.repository.BrandCreateInput;

import java.util.Optional;

public class BrandCreateInputMapper implements Mapper<BrandCreateRequest, BrandCreateInput> {

    @Override
    public BrandCreateInput map(BrandCreateRequest request) {
        BrandCreateInput input = new BrandCreateInput(
                request.getName(),
                request.getCountryCode()
        );
        Optional.ofNullable(request.getSector()).ifPresent(input::setSector);

        return input;
    }

}
