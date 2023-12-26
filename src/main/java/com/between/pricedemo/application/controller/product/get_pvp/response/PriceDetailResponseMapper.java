package com.between.pricedemo.application.controller.product.get_pvp.response;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.domain.entity.Pvp;

public class PriceDetailResponseMapper implements Mapper<Pvp, PriceDetailResponse> {

    @Override
    public PriceDetailResponse map(Pvp pvp) {
        return new PriceDetailResponse(
                pvp.getProductId(),
                pvp.getBrandId(),
                pvp.getPriceId(),
                pvp.getStartDate(),
                pvp.getEndDate(),
                pvp.getPrice()
        );
    }

}
