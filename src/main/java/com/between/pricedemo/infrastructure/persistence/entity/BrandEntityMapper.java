package com.between.pricedemo.infrastructure.persistence.entity;

import com.between.pricedemo.application.contract.Mapper;
import com.between.pricedemo.domain.repository.BrandCreateInput;
import lombok.RequiredArgsConstructor;

import java.time.Clock;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class BrandEntityMapper implements Mapper<BrandCreateInput, BrandEntity> {

    private final Clock clock;

    @Override
    public BrandEntity map(BrandCreateInput input) {
        BrandEntity brandEntity = new BrandEntity()
                .setName(input.getName())
                .setCountryCode(input.getCountryCode())
                .setCreatedAt(LocalDateTime.now(clock));

        input.getSector().ifPresent(brandEntity::setSector);

        return brandEntity;
    }

}
