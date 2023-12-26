package com.between.pricedemo.infrastructure.persistence.entity;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.domain.entity.Pvp;

public class PriceEntityToPvpMapper implements Mapper<PriceEntity, Pvp> {


    @Override
    public Pvp map(PriceEntity entity) {
        return new Pvp(
                entity.getProductId(),
                entity.getBrandId(),
                entity.getId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPrice()
        );
    }

}
