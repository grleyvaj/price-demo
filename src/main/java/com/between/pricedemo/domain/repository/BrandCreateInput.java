package com.between.pricedemo.domain.repository;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

@Accessors(chain = true)
@Data
public class BrandCreateInput {

    private final String name;
    private final String countryCode;
    private String sector;

    public Optional<String> getSector() {
        return Optional.ofNullable(sector);
    }

}
