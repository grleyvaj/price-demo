package com.between.pricedemo.infrastructure.persistence.entity;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.domain.entity.Pvp;

public class PriceProjectionToPvpMapper implements Mapper<PriceProjection, Pvp> {


    @Override
    public Pvp map(PriceProjection projection) {
        return new Pvp(
                projection.getProductId(),
                projection.getBrandId(),
                projection.getId(),
                projection.getStartDate(),
                projection.getEndDate(),
                projection.getPrice()
        );
    }

}
